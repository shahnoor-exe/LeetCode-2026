class Solution {
    public String[] createGrid(int m, int n) {
        String[] x=new String[m];
        x[0]=".".repeat(n);
        for(int i=1;i<m;i++) x[i]="#".repeat(n-1)+".";
        return x;
    }
}