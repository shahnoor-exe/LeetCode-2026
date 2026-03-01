class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            result = encode(result);
        }

        return result;
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char digit = s.charAt(i);
            int count  = 0;
            while (i < s.length() && s.charAt(i) == digit) {
                i++;
                count++;
            }

            sb.append(count).append(digit);
        }

        return sb.toString();
    }
}