from pyspark import SparkContext

sc = SparkContext("local[*]")

# read the text file
items = sc.textFile('receipt.txt')

# map each word with one occurrence
items_mapped = items.map(lambda x: (x.split()[0], float(x.split()[1])))
# print(items_mapped.collect())
# # reduce each word tuples by summing the occurrences
cow = items_mapped.reduceByKey(lambda x, y: round(x + y,2))
#
print(cow.collect())
