import math
import time
import multiprocessing
import pandas as pd
from tqdm import tqdm
from multiprocessing import Pool


def compute_serially(data: str = '../../Combined_Flights_2021.csv'):
    print('using serial execution')
    start = time.time()
    df = pd.read_csv(data)

    print(df['Airline'].value_counts())
    print(f'time taken (serial execution): {round(time.time() - start, 2)} second(s)\n')


def map_tasks(reading_info: list, data: str = '../../Combined_Flights_2021.csv'):
    name = pd.read_csv(data, index_col=None, nrows=0).columns.tolist()
    # print(name)
    # name.insert(0, 'FlightDate')
    # print(name)

    df = pd.read_csv(data, nrows=reading_info[0], skiprows=reading_info[1], names=name)
    # print(df)

    data2 = df[['AirTime', 'OriginCityName', 'DestCityName']]
    data2 = data2[(data2['OriginCityName'] == 'Nashville, TN') & (data2['DestCityName'] == 'Chicago, IL')]
    data2.reset_index().values.tolist()
    # print(data)
    return data2 .values.tolist()


def reduce_task(mapping_output: list):
    reduce_out = pd.DataFrame()
    for out in tqdm(mapping_output):
        temp = pd.DataFrame(out)
        if temp.empty:
            pass
        else:
            reduce_out = pd.concat([reduce_out, temp])
    # result = reduce_out['AirTime'].mean()
    result = reduce_out[0].astype(float).dropna().mean()
    print(result)


def compute_multiprocessing():
    def distribute_rows(n_rows: int, n_processes):
        reading_info = []
        skip_rows = 1
        reading_info.append([n_rows - skip_rows, skip_rows])
        skip_rows = n_rows

        for _ in range(1, n_processes - 1):
            reading_info.append([n_rows, skip_rows])
            skip_rows = skip_rows + n_rows

        reading_info.append([None, skip_rows])
        return reading_info

    total_rows = 6311871
    processes = 4
    # cpu_count = multiprocessing.cpu_count()
    row_subset = math.ceil(total_rows / processes)
    print(distribute_rows(n_rows=row_subset, n_processes=multiprocessing.cpu_count()))
    print('using multiprocessing')
    processes = multiprocessing.cpu_count()
    p = Pool(processes=processes)
    start = time.time()
    result = p.map(map_tasks, distribute_rows(n_rows=row_subset, n_processes=processes))
    reduce_task(result)
    p.close()
    p.join()
    print(
        f'time taken with {processes} processes (multiprocessing execution): {round(time.time() - start, 2)} second(s)')


if __name__ == '__main__':
    # compute_serially()
    compute_multiprocessing()
