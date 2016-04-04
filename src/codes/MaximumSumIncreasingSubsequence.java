package codes;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public static int maximumSumIncresingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] sumArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sumArr[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    sumArr[i] = Math.max(
                            sumArr[j] + nums[i],
                            sumArr[i]);
                }
            }
        }
        return Arrays.stream(sumArr).max().orElse(0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 4, 21, 5 , 18, 12};
        System.out.println(maximumSumIncresingSubsequence(arr));
    }

}
