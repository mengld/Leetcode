class Solution {
    public char firstUniqChar(String s) {

        if (s == "")
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (s.indexOf(aChar) == s.lastIndexOf(aChar))
                return aChar;
        }
        
        return ' ';
    }
}
