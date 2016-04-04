package codes;

public class MaximumSumContigeousSubsequence {

    public static int maximumSumContigeousSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -12, 5, 4, -6, 1, 7, 2, -1, 4, -10};
        System.out.println(maximumSumContigeousSubsequence(arr));
    }

}
