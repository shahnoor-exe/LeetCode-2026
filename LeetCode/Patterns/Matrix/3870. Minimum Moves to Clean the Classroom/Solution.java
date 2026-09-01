class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length, n=classroom[0].length(),lifts=0,sr=0,sc=0;
        int[][] id=new int[m][n];
        for(int[] row:id) Arrays.fill(row,-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=classroom[i].charAt(j);
                if(c=='S') {sr=i;sc=j;}
                else if(c=='L') id[i][j]=lifts++;
            }
        }int target=(1<<lifts)-1;
        if(target==0) return 0;
        int[][][] vis=new int[m][n][1<<lifts];
        for(int[][] v:vis) for(int[] r:v) Arrays.fill(r,-1);
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc,0,energy});
        vis[sr][sc][0]=energy;
        int[] d={-1,0,1,0,-1};
        for(int steps=1;!q.isEmpty();steps++){
            for(int sz=q.size();sz>0;sz--){
                int[] cur=q.poll();
                int r=cur[0],c=cur[1],mask=cur[2],e=cur[3];
                if(e==0) continue;
                for(int i=0;i<4;i++){
                    int nr=r+d[i],nc=c+d[i+1];
                    if(nr<0||nr>=m||nc<0||nc>=n||classroom[nr].charAt(nc)=='X') continue;
                    int nMask=mask|(id[nr][nc]!=-1?1<<id[nr][nc]:0);
                    int nE=classroom[nr].charAt(nc)=='R'?energy:e-1;
                    if(nMask==target) return steps;
                    if(nE>vis[nr][nc][nMask]){
                        vis[nr][nc][nMask]=nE;
                        q.add(new int[]{nr,nc,nMask,nE});
                    }
                }
            }
        }return -1;
    }
}