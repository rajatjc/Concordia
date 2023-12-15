from pyspark import SparkContext
sc = SparkContext("local[*]")
items = sc.textFile('students.txt')
items_mapped = items.flatMap(lambda x: (x.split())).filter(lambda x: not(x.isnumeric())).map(lambda words: (words, 1)).reduceByKey(lambda x, y: x + y)
print(items_mapped.collect())

