class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        int sum = 0;
        int left = 0;
        int minSumOfTwo = Integer.MAX_VALUE;
        int bestSingleLenSoFar = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int currentLen = right - left + 1;
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minSumOfTwo = Math.min(minSumOfTwo, currentLen + minLen[left - 1]);
                }
                bestSingleLenSoFar = Math.min(bestSingleLenSoFar, currentLen);
            }
            minLen[right] = bestSingleLenSoFar;
        }
        return minSumOfTwo == Integer.MAX_VALUE ? -1 : minSumOfTwo;
    }
}