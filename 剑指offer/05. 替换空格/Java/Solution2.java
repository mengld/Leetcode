class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        int p1 = s.length() - 1;
        for (int i = 0; i <= p1; i ++) {
            if (s.charAt(i) == ' ')
                sb.append("  ");
        }

        int p2 = sb.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = sb.charAt(p1--);
            if (c == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            }
            else {
                sb.setCharAt(p2--, c);
            }
        }

        return sb.toString();
    }
}
