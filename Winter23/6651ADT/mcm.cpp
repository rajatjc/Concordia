#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int find_largest_non_overlapping_subset(vector<pair<int, int>> R) {
    // Sort line segments based on first endpoint
    sort(R.begin(), R.end());
    
    // Prepare list A of second endpoints
    vector<int> A(R.size());
    for (int i = 0; i < R.size(); i++) {
        A[i] = R[i].second;
    }
    
    // Initialize longest increasing subsequence array
    vector<int> L(A.size(), 1);
    
    // Compute longest increasing subsequence
    for (int i = 1; i < A.size(); i++) {
        for (int j = 0; j < i; j++) {
            if (A[j] < A[i]) {
                L[i] = max(L[i], L[j] + 1);
            }
        }
    }
    
    // Return length of longest increasing subsequence
    return *max_element(L.begin(), L.end());
}

int main() {
    // vector<pair<int, int>> R = {{1, 1}, {2, 2}, {3, 3},{-1,5},{4,5}};
    // cout << find_largest_non_overlapping_subset(R) << endl; // Output: 2
    // [10, 20, 30, 40, 30]
	int A[6] = {10, 20, 30, 40, 30};
	int N=6;
	int LCS[N];
	LCS[0] = 1; LCS[1] =2 ;

	for(int i=2;i<N;i++)
	{
	LCS[i] = 2;
	for(int j=1;j<i;j++)
	{
		for(int k=0;k<j;k++)
		{
			if(LCS[j]-1 == LCS[k] && A[j] < (A[k] + A[i])/2 )
				LCS[i] = max( LCS[i], 1+LCS[j]);
		}
	}
	}
	for(int i=0;i<N;i++)
	cout<<LCS[i]<<" ";
    return 0;
}
