class Solution {
    public int minOperations(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total % k;
    }
}