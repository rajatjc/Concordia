import time
# import math
import multiprocessing
import pandas as pd
from tqdm import tqdm
from multiprocessing import Pool


def map_tasks(reading_info: list, data: str = '../datasets/region25.csv'):
    df = pd.read_csv(data, nrows=reading_info[0], skiprows=reading_info[1], header=None)
    return df.iloc[:, 5]


def reduce_task(mapping_output: list):
    reduce_out = 0
    # for out in tqdm(mapping_output):
    #     for value in out.tolist():
    #         if math.isnan(value):
    #             reduce_out = reduce_out + 1
    for out in tqdm(mapping_output):
        reduce_out = reduce_out + out.isna().sum()

    print(f'missing values: {reduce_out}')


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

    print('using multiprocessing')
    processes = multiprocessing.cpu_count()
    p = Pool(processes=processes)
    start = time.time()
    result = p.map(map_tasks, distribute_rows(n_rows=200000, n_processes=processes))
    reduce_task(result)
    p.close()
    p.join()
    print(f'time taken with {processes} processes (multiprocessing execution): {round(time.time() - start, 2)} second(s)')


if __name__ == '__main__':
    compute_multiprocessing()
