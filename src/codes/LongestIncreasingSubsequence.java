package codes;

public class LongestIncreasingSubsequence {

    public static int longestIncresingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] subsequenceLengthArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            subsequenceLengthArr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    subsequenceLengthArr[i] = Math.max(
                            subsequenceLengthArr[j] + 1,
                            subsequenceLengthArr[i]);
                }
            }
        }
        return subsequenceLengthArr[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 55, 65, 64, 66 };
        System.out.println(longestIncresingSubsequence(arr));
    }

}
