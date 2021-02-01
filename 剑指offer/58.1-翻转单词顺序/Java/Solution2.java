class Solution {
    public String reverseWords(String s) {

        s = s.trim();

        StringBuilder temp = new StringBuilder();

        if (s.length() == 1)
            return s;
        
        for (int i = 0; i < s.length() - 1; i ++) {
            if (!(s.charAt(i) == ' ' && s.charAt(i + 1) == ' '))
                temp.append(s.charAt(i));
            if (i == s.length() -2)
                temp.append(s.charAt(i + 1));
        }

        s = temp.toString();

        char[] chars = s.toCharArray();
        int length = s.length();
        int i = 0, j = 0;

        while (j <= length) {
            if (j == length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j ++;
        }

        reverse(chars, 0, length-1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i ++, j --);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a"));
    }
}
