class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count  = new HashMap<>();
        Map<Integer, Integer> first  = new HashMap<>();
        Map<Integer, Integer> last   = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            count.put(n, count.getOrDefault(n, 0) + 1);
            first.putIfAbsent(n, i);
            last.put(n, i);
        }

        int degree = Collections.max(count.values());
        int result = nums.length;

        for (int n : count.keySet()) {
            if (count.get(n) == degree) {
                result = Math.min(result, last.get(n) - first.get(n) + 1);
            }
        }

        return result;
    }
}