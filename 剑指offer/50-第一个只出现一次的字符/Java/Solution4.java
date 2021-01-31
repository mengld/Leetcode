import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public char firstUniqChar(String s) {

        Queue<Character> queue = new LinkedList<>();
        int[] maps = new int[26];

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            maps[aChar - 'a']++;
            queue.add(aChar);
            while (!queue.isEmpty() && maps[queue.peek() - 'a'] > 1)
                queue.poll();
        }

        return queue.isEmpty()?' ':queue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }
}
