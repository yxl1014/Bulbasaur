package leetcode.number.number17.queue;

import java.util.*;

/**
 * @author yxl
 * @date 2023/2/1 下午7:15
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res;
        if (digits.length() == 0)
            return new ArrayList<>();
        HashMap<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Queue<String> queue = new ArrayDeque<>();
        for (char c : digits.toCharArray()) {
            String str = phoneMap.get(c);
            if (queue.size() == 0) {
                for (char cc : str.toCharArray()) {
                    queue.offer("" + cc);
                }
            } else {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                    for (char cc : str.toCharArray()) {
                        queue.offer(poll + cc);
                    }
                }
            }
        }
        res = new ArrayList<>(queue);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
