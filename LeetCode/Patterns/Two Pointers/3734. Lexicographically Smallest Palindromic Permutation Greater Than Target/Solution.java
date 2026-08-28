class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length(),m=n/2,odd=0,mid=-1;
        int[] half=new int[26];
        for(char c:s.toCharArray()) half[c-'a']++;
        for(int i=0;i<26;i++){
            if(half[i]%2!=0) {odd++; mid=i;}
            half[i]/=2;
        }if(odd>1) return "";
        for(int i=m;i>=0;i--){
            int[] rem=half.clone();
            StringBuilder first= new StringBuilder();
            Boolean isValidPrefix=true;
            for(int j=0;j<i;j++){
                int c=target.charAt(j)-'a';
                if(--rem[c]<0){isValidPrefix=false; break;}
                first.append((char)(c+'a'));
            }if(!isValidPrefix) continue;
            if(i==m){
                String cand=build(first,mid,n);
                if(cand.compareTo(target)>0) return cand;
            }else{
                for(int c=target.charAt(i)-'a'+1;c<26;c++){
                    if(rem[c]>0){
                        first.append((char)(c+'a'));
                        rem[c]--;
                        for(int k=0;k<26;k++){
                            while(rem[k]-->0) first.append((char)(k+'a'));
                        }return build(first,mid,n);
                    }
                }
            }
        }return "";
    }
    private String build(StringBuilder half, int mid, int n){
        StringBuilder res=new StringBuilder(half);
        if(n%2!=0) res.append((char)(mid+'a'));
        for(int i=half.length()-1;i>=0;i--) res.append(half.charAt(i));
        return res.toString();
    }
}