#include<bits/stdc++.h>
using namespace std;

const int MAXN = 1e5 + 5;
vector<int> g[MAXN];
int n, m, c[MAXN];

void dfs(int u, int color) {
    c[u] = color;
    for(auto v: g[u]) {
        if(!c[v]) dfs(v, 3 - color);
    }
}

int main() {
    cin >> n >> m;
    for(int i = 1; i <= m; i++) {
        int u, v;
        cin >> u >> v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    for(int i = 1; i <= n; i++) {
        if(!c[i]) dfs(i, 1);
    }
    for(int i = 1; i <= n; i++) {
        cout << c[i] << " ";
    }
    cout << endl;
    return 0;
}
