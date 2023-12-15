import random


def graph_gen(n, k):
    # Step 1: partition the vertices into k disjoint subsets
    value = random.random()
    p = value
    print(p)
    subsets = [[] for _ in range(k)]
    for i in range(n):
        subsets[i % k].append(i)

    # Step 2: generate edges between vertices in different subsets
    edges = set()
    for i in range(n):
        for j in range(i + 1, n):
            # newv = random.random()
            # print(newv)
            if i in subsets[j % k] or j in subsets[i % k]:
                # vertices belong to the same subset, do nothing
                continue
            elif random.random() < p:
                # generate edge with probability p

                edges.add((i, j))



    # Construct the graph as a dictionary of adjacency lists
    graph = {i: [] for i in range(n)}
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    # print(graph)
    return graph


graph_gen(5, 3)
