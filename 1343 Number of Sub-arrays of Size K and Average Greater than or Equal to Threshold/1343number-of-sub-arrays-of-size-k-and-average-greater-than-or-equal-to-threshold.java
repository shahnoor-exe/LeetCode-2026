class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cs=0; int c=0;
        for(int i=0;i<k;i++){
            cs+=arr[i];
        } 
        if(cs>=threshold*k) c++;
        for(int i=k;i<arr.length;i++) {
            cs=cs+arr[i]-arr[i-k];
            if(cs>=threshold*k) c++;
        }
        return c;
    }
}