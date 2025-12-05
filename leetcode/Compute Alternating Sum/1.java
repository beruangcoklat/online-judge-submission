class Solution {
    public int alternatingSum(int[] nums) {
        int result = 0;
        boolean plus = true;
        for (int i = 0; i < nums.length; i++) {
            result += (plus ? nums[i] : -nums[i]);
            plus = !plus;
        }
        return result;
    }
}