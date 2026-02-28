class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;

        int n = s.length(), k = words.length, w = words[0].length();
        int windowLen = k * w;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }
        for (int offset = 0; offset < w; offset++) {
            Map<String, Integer> windowMap = new HashMap<>();
            int matched = 0;
            int left = offset;

            for (int right = offset; right + w <= n; right += w) {
                String word = s.substring(right, right + w);

                if (wordCount.containsKey(word)) {
                    windowMap.merge(word, 1, Integer::sum);
                    if (windowMap.get(word) <= wordCount.get(word)) {
                        matched++;
                    } else {
                        while (windowMap.get(word) > wordCount.get(word)) {
                            String leftWord = s.substring(left, left + w);
                            windowMap.merge(leftWord, -1, Integer::sum);
                            if (windowMap.get(leftWord) < wordCount.getOrDefault(leftWord, 0)) {
                                matched--;
                            }
                            left += w;
                        }
                    }

                    if (matched == k) {
                        result.add(left);
                        String leftWord = s.substring(left, left + w);
                        windowMap.merge(leftWord, -1, Integer::sum);
                        matched--;
                        left += w;
                    }
                } else {
                    windowMap.clear();
                    matched = 0;
                    left = right + w;
                }
            }
        }

        return result;
    }
}