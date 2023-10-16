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
    names = pd.read_csv(data, index_col=None, nrows=0).columns.tolist()
    df = pd.read_csv(data, nrows=reading_info[0], skiprows=reading_info[1], names=names)
    # print(df)

    data = df[['Airline', 'Cancelled', 'Year', 'Month']]
    data = data[(data['Year'] == 2021) & (data['Month'] == 9) & (data['Cancelled'] == True)]
    data = data['Airline'].value_counts()
    data = data.to_frame()
    data.reset_index().values.tolist()
    # print(data)
    return data.reset_index().values.tolist()


def reduce_task(mapping_output: list):
    reduce_out = pd.DataFrame()
    for out in tqdm(mapping_output):
        temp = pd.DataFrame(out)
        if temp.empty:
            pass
        else:
            reduce_out = pd.concat([reduce_out, temp])
    result = reduce_out.groupby([0]).sum().reset_index()
    print(reduce_out)

    maximum = result.loc[result[1].idxmax()]
    print(maximum)


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
    # cpu_count = 10
    cpu_count = multiprocessing.cpu_count()
    print(cpu_count)
    row_subset = math.ceil(total_rows / cpu_count)
    print(distribute_rows(n_rows=row_subset, n_processes=multiprocessing.cpu_count()))
    print('using multiprocessing')
    processes = multiprocessing.cpu_count()
    p = Pool(processes=processes)
    start = time.time()
    result = p.map(map_tasks, distribute_rows(n_rows=row_subset, n_processes=processes))
    # reduce_task(result)
    p.close()
    p.join()
    print(
        f'time taken with {processes} processes (multiprocessing execution): {round(time.time() - start, 2)} second(s)')


if __name__ == '__main__':
    # compute_serially()
    compute_multiprocessing()
