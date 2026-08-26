class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int n1=n/2;
        char[] c=s.substring(0,n1).toCharArray();
        Arrays.sort(c);
        String s1=new String(c);
        String s2=(n%2!=0) ? String.valueOf(s.charAt(n1)):"";
        String s3=new StringBuilder(s1).reverse().toString();
        return s1+s2+s3;
    }
}