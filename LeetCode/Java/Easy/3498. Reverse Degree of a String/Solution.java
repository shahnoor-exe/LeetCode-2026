class Solution {
    public int reverseDegree(String s) {
        int x=0;
        for(int i=0;i<s.length();i++){
            int y=26-(s.charAt(i)-'a');
            int z=i+1;
            x+=y*z;
        }return x;
    }
}