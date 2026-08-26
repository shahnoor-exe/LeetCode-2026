class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length(),x=0,l=0;
        String r= "";
        for(int ri=0;ri<n;ri++){
            if(s.charAt(ri)=='1') x++;
            while(x>k||(l<ri &&s.charAt(l)=='0')){
                if(s.charAt(l)=='1') x--;
                l++;
            }
            if(x==k){
                String s1=s.substring(l,ri+1);
                if(r.isEmpty()||s1.length()<r.length()||(s1.length()==r.length() && s1.compareTo(r)<0)) r=s1;
            }
        }return r;
    }
}