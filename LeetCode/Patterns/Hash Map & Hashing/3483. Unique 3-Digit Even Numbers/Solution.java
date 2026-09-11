class Solution {
    public int totalNumbers(int[] digits) {
        int[] c=new int[10];
        for(int d:digits) c[d]++;
        int n=0;
        for(int i=100;i<999;i+=2){
            int ones=i%10;
            int tens=(i/10)%10;
            int hundreds=i/100;
            c[ones]--;
            c[tens]--;
            c[hundreds]--;
            if(c[ones]>=0 && c[tens]>=0 && c[hundreds]>=0) n++;
            c[ones]++;
            c[tens]++;
            c[hundreds]++;
        }return n;
    }
}