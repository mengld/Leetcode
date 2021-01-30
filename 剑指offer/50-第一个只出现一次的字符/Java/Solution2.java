class Solution {
    public char firstUniqChar(String s) {

        if (s == "")
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        int[] maps = new int[128];
        for (int i = 0; i < s.length(); i ++) {
            maps[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i ++) {
            if (maps[s.charAt(i)] == 1)
                return s.charAt(i);
        }

        return ' ';
    }
}
