package leetcode.number17.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxl
 * @date 2023/2/1 下午7:03
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
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
        dfs(res, phoneMap, digits, 0, new StringBuffer());
        return res;
    }

    private void dfs(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //若到达边界则添加到数组当中 返回
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            //否则获取这个数字对应的字母
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();

            //遍历这些数组
            for (int i = 0; i < lettersCount; i++) {
                //添加到当前字符串当中
                combination.append(letters.charAt(i));
                //递归下一个数字
                dfs(combinations, phoneMap, digits, index + 1, combination);
                //执行完这个字母 将新添加的字母删除
                combination.deleteCharAt(index);
            }
        }
    }
}
