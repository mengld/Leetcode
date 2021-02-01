class Solution {
    public String reverseWords(String s) {

        if (s == null || s.length() == 0 || s == "")
            return "";
        if (s.equals(" "))
            return "";

        s = s.trim();

        if (s.length() == 1)
            return s;

        StringBuilder temp = new StringBuilder();


        for (int i = 0; i < s.length() - 1; i ++) {
            if (!(s.charAt(i) == ' ' && s.charAt(i + 1) == ' '))
                temp.append(s.charAt(i));
            if (i == s.length() -2)
                temp.append(s.charAt(i + 1));
        }

        s = temp.toString();

        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i --) {
            res.append(words[i] + (i == 0?"":" "));
        }

        return res.toString();
    }
}
