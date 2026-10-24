class Solution {
    int[] x={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1=d(arriveAlice), a2=d(leaveAlice);
        int b1=d(arriveBob), b2=d(leaveBob);
        return Math.max(0,(Math.min(a2,b2)-Math.max(a1,b1)+1));
    }
    private int d(String s){
        int y=(s.charAt(0)-'0')*10 + s.charAt(1)-'0';
        int d=(s.charAt(3)-'0')*10 + s.charAt(4)-'0';
        for(int i=1;i<y;i++) d+=x[i];
        return d;
    }
}