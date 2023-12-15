from threading import Thread
import math
import numpy as np
import time
import pandas as pd
from tqdm import tqdm

result = []

total_rows = 6311871

num_of_threads = 10

mapping_output = []


def map_tasks(reading_info: list, data: str = '../../Combined_Flights_2021.csv'):
    names = pd.read_csv(data, index_col=None, nrows=0).columns.tolist()
    df = pd.read_csv(data, nrows=reading_info[0], skiprows=reading_info[1], names=names)

    global mapping_output
    # print(df)

    data = df[['Airline', 'Cancelled', 'Year', 'Month']]
    data = data[(data['Year'] == 2021) & (data['Month'] == 9) & (data['Cancelled'] == True)]
    data = data['Airline'].value_counts()
    data = data.to_frame()

    mapping_output.append(data.reset_index().values.tolist())


def reduce_task(mapping_output: list):
    reduce_out = pd.DataFrame()
    for out in tqdm(mapping_output):
        temp = pd.DataFrame(out)
        if temp.empty:
            pass
        else:
            reduce_out = pd.concat([reduce_out, temp])
    result = reduce_out.groupby([0]).sum().reset_index()
    # print(reduce_out)

    maximum = result.loc[result[1].idxmax()]
    print(maximum)


def distribute_rows(n_rows: int, n_threads):
    reading_info = []
    skip_rows = 1
    reading_info.append([n_rows - skip_rows, skip_rows])
    skip_rows = n_rows

    for _ in range(1, n_threads - 1):
        reading_info.append([n_rows, skip_rows])
        skip_rows = skip_rows + n_rows

    reading_info.append([None, skip_rows])
    return reading_info


def Thread_function():
    global num_of_threads
    global total_rows
    thread_handle = []
    global mapping_output
    output = distribute_rows(n_rows=int(total_rows / num_of_threads), n_threads=num_of_threads)
    for j in range(0, num_of_threads):
        reading_info = output[j]

        t = Thread(target=map_tasks(reading_info))
        thread_handle.append(t)

    for t in thread_handle:
        t.start()

    for j in range(0, num_of_threads):
        thread_handle[j].join()
    #
    # print(mapping_output)
    reduce_task(mapping_output)


if __name__ == "__main__":
    # multithread execution
    start = time.time()
    Thread_function()

    print(
        f'time taken with {num_of_threads} processes (multithreading execution): {round(time.time() - start, 2)} second(s)')
