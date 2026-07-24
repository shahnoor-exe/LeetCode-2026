class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> r=new ArrayList<>();
        for(int[] i:intervals){
            if(newInterval==null||i[1]<newInterval[0]) r.add(i);
            else if(i[0]>newInterval[1]){
                r.add(newInterval);
                r.add(i);
                newInterval=null;
            }else {
                newInterval[0]=Math.min(newInterval[0],i[0]);
                newInterval[1]=Math.max(newInterval[1],i[1]);
            }            
        }if(newInterval!=null) r.add(newInterval);
        return r.toArray(new int[0][]);
    }
}