class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n < 1)
            return "";
        if (s.length() == 1)
            return s;

        n = n % s.length();
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());

        return s2 + s1;
    }
}
