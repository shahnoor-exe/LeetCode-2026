class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > 0 && dfs(grid, i, j, k) == 0) ans++;
        return ans;
    }
    private int dfs(int[][] g, int i, int j, int k) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0) return 0;
        int v = g[i][j] % k;
        g[i][j] = 0;
        return (v + dfs(g, i + 1, j, k) + dfs(g, i - 1, j, k) + dfs(g, i, j + 1, k) + dfs(g, i, j - 1, k)) % k;
    }
}