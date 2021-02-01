class Solution {
    public String reverseLeftWords(String s, int n) {

        if (s == null || s.length() == 0 || n < 1)
            return "";
        if (s.length() == 1)
            return s;

        n = n % s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("hello", 2));
    }
}
