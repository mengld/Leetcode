class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] maxLen = new int[len1 + 1][len2 + 1];

        int i, j;
        for (i = 0; i < len1; i ++) {
            maxLen[i][0] = 0;
        }
        for (j = 0; j < len2; j ++) {
            maxLen[0][j] = 0;
        }

        for (i = 1; i <= len1; i ++) {
            for (j = 1; j <= len2; j ++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    maxLen[i][j] = maxLen[i-1][j-1] + 1;
                }
                else {
                    maxLen[i][j] = Math.max(maxLen[i][j-1], maxLen[i-1][j]);
                }
            }
        }

        return maxLen[len1][len2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}
