// C++ Program for Floyd Warshall Algorithm
#include <bits/stdc++.h>
using namespace std;

// Number of vertices in the graph
#define V 7

/* Define Infinite as a large enough
value.This value will be used for
vertices not connected to each other */
#define INF 99999

// A function to print the solution matrix
void printSolution(int dist[][V]);

// Solves the all-pairs shortest path
// problem using Floyd Warshall algorithm
void floydWarshall(int dist[][V])
{

	int i, j, k;


	int count[V][V]={0};
	for (i = 0; i < V; i++) {
			
			for (j = 0; j < V; j++) {
				if(i!=j)
			{
				if(dist[i][j]!=INF )
					count[i][j]=1;
			}
			}
		}

	for (k = 0; k < V; k++) {
	
		for (i = 0; i < V; i++) {
			
			for (j = 0; j < V; j++) {
				
				if (dist[i][j] >= (dist[i][k] + dist[k][j])
					&& (dist[k][j] != INF
						&& dist[i][k] != INF)&&i!=j)
					{
						dist[i][j] = dist[i][k] + dist[k][j];
						if(k!=i && k!=j)
							count[i][j]+=1;			
						
					}
			}
		}
     
	}

}

/* A utility function to print solution */
void printSolution(int dist[][V])
{
	// // cout << "The following matrix shows the shortest "
	// 		"distances"
	// 		" between every pair of vertices \n";
	for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
			if (dist[i][j] == INF)
				cout << "∞"
					<< "\t";
			else
				cout << dist[i][j] << "\t";
		}
		cout << endl;
	}
}

// Driver's code
int main()
{

	int graph[V][V] = {
    {0, 5, 7, INF, INF, INF, 16},
    {INF, 0, INF, 5, 3, INF, INF},
    {INF, -2, 0, INF, 3, INF, INF},
    {INF, INF, -2, 0, 0, INF, INF},
    {INF, INF, INF, INF, 0, INF, INF},
    {INF, INF, INF, INF, -1, 0, INF},
    {INF, INF, INF, 6, INF, 2, 0}
};

	// Function call
	floydWarshall(graph);
	return 0;
}
