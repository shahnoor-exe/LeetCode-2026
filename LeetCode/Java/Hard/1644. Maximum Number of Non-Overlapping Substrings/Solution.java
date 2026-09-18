class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                int right = getValidRightBound(s, i, first, last);
                if (right != -1) {
                    intervals.add(new int[]{first[i], right});
                }
            }
        }
        Collections.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0]; 
            return a[1] - b[1];
        });
        List<String> result = new ArrayList<>();
        int prevRight = -1;
        for (int[] interval : intervals) {
            if (interval[0] > prevRight) {
                result.add(s.substring(interval[0], interval[1] + 1));
                prevRight = interval[1];
            }
        }
        return result;
    }
    private int getValidRightBound(String s, int charIdx, int[] first, int[] last) {
        int start = first[charIdx];
        int right = last[charIdx];
        for (int j = start; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (first[c] < start) {
                return -1;
            }
            right = Math.max(right, last[c]);
        }
        return right;
    }
}