class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
        int[] c=new int[26];
        for(char c1:s.toCharArray()) c[c1-'a']++;
        for(int i=n-1;i>=0;i--){
            int[] r=c.clone();
            boolean p=true;
            for(int j=0;j<i;j++){
                int c2=target.charAt(j)-'a';
                if(--r[c2]<0){
                    p=false; break;
                }
            }if(!p) continue;
            int c2=target.charAt(i)-'a';
            int c3=-1;
            for(int c4=c2+1;c4<26;c4++){
                if(r[c4]>0){
                    c3=c4; break;
                }
            }
            if(c3!=-1){
                StringBuilder s1=new StringBuilder();
                s1.append(target,0,i);
                s1.append((char)('a'+c3));
                r[c3]--;
                for(int c4=0;c4<26;c4++){
                    while(r[c4]-->0) s1.append((char)('a'+c4));
                }return s1.toString();
            }
        }return "";
    }
}