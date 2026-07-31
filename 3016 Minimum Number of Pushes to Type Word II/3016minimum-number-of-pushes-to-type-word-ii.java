class Solution {
    public int minimumPushes(String word) {
        int[] s=new int[26];
        for (char c : word.toCharArray()) {
            s[c - 'a']++;
        }
        Arrays.sort(s);
        int n = 0;
        int x = 0;
        for (int i = 25; i >= 0; i--) {
            if (s[i] == 0) break;
            int p = (x / 8) + 1;
            n += s[i]*p;
            x++;
        }
        return n;
    }
}