class Solution {
    public int[] validSequence(String word1, String word2) {
        int[] r=new int[word2.length()];
        int[] x=new int[word2.length()];
        for(int j=word2.length()-1,i=word1.length()-1;j>=0;j--){
            while(i>=0 && word1.charAt(i)!=word2.charAt(j)) i--;
            x[j]=i--;
        }
        boolean y=false;
        for(int j=0,i=0;j<word2.length();j++){
            while(i<word1.length() && word1.charAt(i) != word2.charAt(j) && (y||(j+1<word2.length() && x[j+1]<=i))) i++;
            if(i>=word1.length()) return new int[0];
            else if(word1.charAt(i)!=word2.charAt(j)) y=true;
            r[j]=i++;
        }return r;
    }
}