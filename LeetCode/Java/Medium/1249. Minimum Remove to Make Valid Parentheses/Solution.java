class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] c=s.toCharArray();
        int ct=0;
        for(int i=0;i<s.length();i++){
            if(c[i]=='(') ct++;
            else if(c[i]==')'){
                if(ct==0) c[i]='*';
                else ct--;
            }
        }for(int i=s.length()-1;i>=0;i--){
            if(ct>0 && c[i]=='('){
                c[i]='*';
                ct--;
            }
        }StringBuilder s1=new StringBuilder();
        for(char c1:c){
            if(c1!='*') s1.append(c1);
        }return s1.toString();
    }
}