class Solution {
    int m,n;
    boolean[][][] v;
    public boolean hasValidPath(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if((m+n-1)%2!=0||grid[0][0]==')'||grid[m-1][n-1]=='('){
            return false;
        }v=new boolean[m][n][(m+n+1)/2];
        return dfs(0,0,0,grid);
    }private boolean dfs(int i,int j,int b,char[][] g) {
        b+=g[i][j]=='('?1:-1; 
        if(b<0||b>=v[0][0].length) return false;
        if(i==m-1 && j==n-1) return b==0;
        if(v[i][j][b]) return false;
        v[i][j][b]=true;
        return(i<m-1 && dfs(i+1,j,b,g))||(j<n-1 && dfs(i,j+1,b,g));
    }
}