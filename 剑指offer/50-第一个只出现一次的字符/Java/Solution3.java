class Solution {
    public char firstUniqChar(String s) {

        if (s == "")
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        BitSet b1 = new BitSet();
        BitSet b2 = new BitSet();

        for (char c : s.toCharArray()) {
            if (!b1.get(c) && !b2.get(c))
                b1.set(c);
            else if (b1.get(c) && !b2.get(c))
                b2.set(c);
        }

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (b1.get(c) && !b2.get(c))
                return c;
        }

        return ' ';
    }
}
