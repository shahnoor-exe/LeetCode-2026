class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> r=new ArrayList<>();
        int[] c=intervals[0];
        r.add(c);
        for(int[] i:intervals) {
            if(i[0]<=c[1]) c[1]=Math.max(c[1],i[1]);
            else {
                c=i;
                r.add(c);
            }
        }return r.toArray(new int[0][]);
    }
}