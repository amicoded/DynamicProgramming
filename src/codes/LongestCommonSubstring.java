package codes;

public class LongestCommonSubstring {
    
    static String longestCommonSubstring(String s1, String s2) {
        int[][] lengthMat = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0, maxLengthIdx = 0;
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lengthMat[i][j] = lengthMat[i-1][j-1] + 1;
                    if(maxLength < lengthMat[i][j]) {
                        maxLength = lengthMat[i][j];
                        maxLengthIdx = i;
                        System.out.println(maxLength + " " + maxLengthIdx);
                    }
                    
                }
            }
        }
        return s1.substring(maxLengthIdx - maxLength, maxLengthIdx);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("hihellohi", "hihedehellode"));

    }

}
