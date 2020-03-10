package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
电话号码的字母组合
 */
public class LeetCode17 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public List<String> letterCombinations2(String digits) {
        //通过这个先决条件 对边界值进行过滤
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        List<String> letter = new ArrayList<>();
        letter.add("");
        for (int p = 0; p < digits.length(); p++) {//电话号码循环
            String temp = digits.substring(p, p + 1);//按下的当前字母
            int size = letter.size();
            //因为边界值在上面已经进行了修正
//            if (size == 0) {
//                for (int j = 0; j < phone.get(temp).length(); j++) {
//                    letter.add(phone.get(temp).substring(j, j + 1));
//                }
//                continue;
//            }
            for (int i = 0; i < size; i++) {//队列取出循环
                String first = letter.get(0);
                letter.remove(0);
                for (int j = 0; j < phone.get(temp).length(); j++) {
                    letter.add(first + phone.get(temp).substring(j, j + 1));
                }
            }
        }
        return letter;
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations2(""));
    }
}