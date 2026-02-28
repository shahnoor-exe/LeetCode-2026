class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);

        Set<Integer> resultSet = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) resultSet.add(n);
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int n : resultSet) result[i++] = n;
        return result;
    }
}