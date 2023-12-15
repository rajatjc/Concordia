import math
import sys

import pandas as pd
from mpi4py import MPI
import time

comm = MPI.COMM_WORLD
size = comm.Get_size()
rank = comm.Get_rank()

dataset = '../../Combined_Flights_2021.csv'
total_rows = 6311871

start = time.time()

if rank == 0:

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


    row_subset = math.ceil(total_rows / size - 1)
    chunk_distribution = distribute_rows(n_rows=row_subset, n_processes=size - 1)

    # distribute tasks to slaves
    for worker in range(1, size):
        chunk_to_process = worker - 1
        comm.send(chunk_distribution[chunk_to_process], dest=worker)

    # receive and aggregate results from slave
    reduce_out = pd.DataFrame()

    for worker in (range(1, size)):

        result = comm.recv(source=worker)
        if result:
            result = pd.DataFrame(result)
            reduce_out = pd.concat([reduce_out, result])
        print(f'received from Worker slave {worker}')

    result = reduce_out[0].astype(float).dropna().mean()
    print(result)
    print(
        f'time taken with {size - 1} slaves (MPI execution): {round(time.time() - start, 2)} second(s)')

elif rank > 0:
    chunk_to_process = comm.recv()
    print(f'Worker {rank} is assigned chunk info {chunk_to_process} {dataset}')
    names = pd.read_csv(dataset, index_col=None, nrows=0).columns.tolist()
    df = pd.read_csv(dataset, nrows=chunk_to_process[0], skiprows=chunk_to_process[1], names=names)
    # print(df)

    data2 = df[['AirTime', 'OriginCityName', 'DestCityName']]
    data2 = data2[(data2['OriginCityName'] == 'Nashville, TN') & (data2['DestCityName'] == 'Chicago, IL')]
    # print(data)
    result = data2.values.tolist()
    # print(data)

    print(f'Worker slave {rank} is done. Sending back to master')
    comm.send(result, dest=0)
