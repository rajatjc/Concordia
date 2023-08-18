import time
import pandas as pd


def compute_serially():
    print('using serial execution')
    start = time.time()
    df = pd.read_csv('../datasets/region25.csv')
    missing_values = df.iloc[:, 5].isna().sum()
    print(f'missing values: {missing_values}')
    print(f'time taken (serial execution): {round(time.time()-start, 2)} second(s)\n')


if __name__ == '__main__':
    compute_serially()
