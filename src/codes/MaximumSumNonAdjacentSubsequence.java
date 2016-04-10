package codes;

public class MaximumSumNonAdjacentSubsequence {

    public static int maximumSumNonAdjacentSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        sumArr[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            sumArr[i] = Math.max(nums[i] + sumArr[i-2], sumArr[i-1]);
        }
        return sumArr[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {2,1,6,7,5,3,7,10};
        System.out.println(maximumSumNonAdjacentSubsequence(arr));
    }

}
