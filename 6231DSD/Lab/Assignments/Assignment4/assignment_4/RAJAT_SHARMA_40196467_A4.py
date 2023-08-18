import os
from itertools import permutations

from pyspark import RDD, SparkContext
from pyspark.sql import DataFrame, SparkSession
import pyspark.sql.functions as F


def myfunc(temp):
    xyz = []
    for i in permutations(temp.split(","), 2):
        xyz.append((i, 1))
    return xyz


def restaurant_shift_coworkers(worker_shifts: RDD) -> RDD:
    # the output type is [(str,str)] -> comma separated
    # here we are just splitting the data into dates and the worker names
    items_mapped = worker_shifts.map(lambda x: (x.split(",")[1], (x.split(",")[0])))

    # the output type is [(str1,str2)] -> str2 is list of names separated by a comma(,)
    # here we are just reducing the names and grouping them on the basis of date the list of names is appended using comma(,) as a delimiter
    items_mapped = items_mapped.reduceByKey(lambda p, q: p + ',' + q)

    # the output type here is a [(tuple,int)] tuple is the list of names and int is representing it's count i.e 1 for now
    # here we are mapping the names and converting them to pair tuple with the count as 1 for each tuple
    items_mapped = items_mapped.flatMap(lambda x: myfunc(x[1]))

    # the output type here is  [(tuple,int)] here int is the total count of the pair tuple
    # here we are grouping the count and finding how many such pairs with the same tuple exists
    items_mapped = items_mapped.reduceByKey(lambda x, y: x + y)

    # the output type here is  [(tuple,int)]
    # here we are sorting on the basis of name in descending order
    items_mapped = items_mapped.sortBy(lambda x: x[0], ascending=False)

    # the output type here is  [(tuple,int)]
    # here we are sorting on the basis of number of shifts in descending order
    items_mapped = items_mapped.sortBy(lambda x: x[1], ascending=False)

    return items_mapped
    """
    Takes an RDD that represents the contents of the worker_shifts.txt. Performs a series of MapReduce operations via
    PySpark to calculate the number of shifts worked together by each pair of co-workers. Returns the results as an RDD
    sorted by the number of shifts worked together THEN by the names of co-workers in a DESCENDING order.
    :param worker_shifts: RDD object of the contents of worker_shifts.txt.
    :return: RDD of pairs of co-workers and the number of shifts they worked together sorted in a DESCENDING order by
             the number of shifts then by the names of co-workers.
             Example output: [(('Shreya Chmela', 'Fabian Henderson'), 3),
                              (('Fabian Henderson', 'Shreya Chmela'), 3),
                              (('Shreya Chmela', 'Leila Jager'), 2),
                              (('Leila Jager', 'Shreya Chmela'), 2)]
    """




def air_flights_most_canceled_flights(flights: DataFrame) -> str:
    data = flights.select(['Airline', 'Cancelled', 'Year', 'Month'])
    data = data.where((flights.Year == 2021) & (flights.Month == 9) & (flights.Cancelled == True))
    data = data.groupBy('Airline').count().sort(F.col('count').desc()).take(1)
    return data[0].asDict()['Airline']
    """
    Takes the flight data as a DataFrame and finds the airline that had the most canceled flights on Sep. 2021
    :param flights: Spark DataFrame of the flights CSV file.
    :return: The name of the airline with most canceled flights on Sep. 2021.
    """


def air_flights_diverted_flights(flights: DataFrame) -> int:
    """
    Takes the flight data as a DataFrame and calculates the number of flights that were diverted in the period of 
    20-30 Nov. 2021.
    :param flights: Spark DataFrame of the flights CSV file.
    :return: The number of diverted flights between 20-30 Nov. 2021.
    """
    data1 = flights.select(['Airline', 'FlightDate', 'Diverted'])
    data1 = data1.where(
        (data1.FlightDate >= '2021-11-20') & (data1.FlightDate <= '2021-11-30') & (data1.Diverted == True))
    return data1.count()

    # raise NotImplementedError('Your Implementation Here.')


def air_flights_avg_airtime(flights: DataFrame) -> float:
    """
    Takes the flight data as a DataFrame and calculates the average airtime of the flights from Nashville, TN to 
    Chicago, IL.
    :param flights: Spark DataFrame of the flights CSV file.
    :return: The average airtime of the flights from Nashville, TN to
    Chicago, IL.
    """
    # raise NotImplementedError('Your Implementation Here.')
    data2 = flights.select(['AirTime', 'OriginCityName', 'DestCityName'])
    data2 = data2.where((data2.OriginCityName == 'Nashville, TN') & (data2.DestCityName == 'Chicago, IL')).dropna().agg(
        {'AirTime': 'mean'})
    return data2.collect()[0].asDict().get('avg(AirTime)')


def air_flights_missing_departure_time(flights: DataFrame) -> int:
    """
    Takes the flight data as a DataFrame and find the number of unique dates where the departure time (DepTime) is 
    missing.
    :param flights: Spark DataFrame of the flights CSV file.
    :return: the number of unique dates where DepTime is missing. 
    """
    data3 = flights.select(['DepTime', 'FlightDate'])
    return data3.filter(data3.DepTime.isNull()).groupBy('FlightDate').count().count()
    # raise NotImplementedError('Your Implementation Here.')


def main():
    # initialize SparkContext and SparkSession
    sc = SparkContext('local[*]')
    spark = SparkSession.builder.getOrCreate()

    print('########################## Problem 1 ########################')
    # problem 1: restaurant shift coworkers with Spark and MapReduce 
    # read the file

    worker_shifts = sc.textFile('worker_shifts.txt')
    sorted_num_coworking_shifts = restaurant_shift_coworkers(worker_shifts)
    # # print the most, least, and average number of shifts together
    #
    sorted_num_coworking_shifts.persist()
    print('Co-Workers with most shifts together:', sorted_num_coworking_shifts.first())
    print('Co-Workers with least shifts together:', sorted_num_coworking_shifts.sortBy(lambda x: (x[1], x[0])).first())
    print('Avg. No. of Shared Shifts:',
          sorted_num_coworking_shifts.map(lambda x: x[1]).reduce(
              lambda x, y: x + y) / sorted_num_coworking_shifts.count())

    print('########################## Problem 2 ########################')
    # problem 2: PySpark DataFrame operations
    # read the file

    flights = spark.read.csv('Combined_Flights_2021.csv', header=True, inferSchema=True)

    print('Q1:', air_flights_most_canceled_flights(flights), 'had the most canceled flights in September 2021.')
    print('Q2:', air_flights_diverted_flights(flights), 'flights were diverted between the period of 20th-30th '
                                                        'November 2021.')
    print('Q3:', air_flights_avg_airtime(flights), 'is the average airtime for flights that were flying from '
                                                   'Nashville to Chicago.')
    print('Q4:', air_flights_missing_departure_time(flights), 'unique dates where departure time (DepTime) was '
                                                              'not recorded.')


if __name__ == '__main__':
    main()
