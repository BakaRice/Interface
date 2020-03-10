package Leetcode;

public class LeetCode12 {
    public String intToRoman(int num) {
        String roman = new String("");
        int[] splitnum = new int[4];
        for (int i = 0; i <= 3; i++) {
            splitnum[i] = num % 10;
            num = num / 10;
        }
        for (int i = 0; i < splitnum[3]; i++) {
            roman = roman+"M";
        }
        for (int i = 0; i < splitnum[2]; i++) {
            if (splitnum[2] == 9) {
                roman = roman+"CM";
                break;
            } else if (splitnum[2] == 4) {
                roman = roman+"CD";
                break;
            }else if (splitnum[2] >=5){
                roman = roman+"D";
                splitnum[2] = splitnum[2]-5;
                i = -1;
            }else
                roman = roman+"C";
        }
        for (int i = 0; i < splitnum[1]; i++) {
            if (splitnum[1] == 9) {
                roman = roman+"XC";
                break;
            } else if (splitnum[1] == 4) {
                roman = roman+"XL";
                break;
            }else if (splitnum[1] >=5){
                roman = roman+"L";
                splitnum[1] = splitnum[1]-5;
                i = -1;
            }else
                roman = roman+"X";
        }
        for (int i = 0; i < splitnum[0]; i++) {
            if (splitnum[0] == 9) {
                roman = roman+"IX";
                break;
            } else if (splitnum[0] == 4) {
                roman = roman+"IV";
                break;
            }else if (splitnum[0] >=5){
                roman = roman+"V";
                splitnum[0] = splitnum[0]-5;
                i = -1;
            }else
                roman = roman+"I";
        }
        return roman;
    }

    public String intToRoman2(int num) {
        StringBuilder ans = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
        int index = 0;
        while (num > 0) {
            int count = num / arab[index];
            while (count-- > 0) {
                ans.append(roman[index]);
            }
            num %= arab[index];
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
        System.out.print(leetCode12.intToRoman2(3358));//"1194 MCMXCIV"

    }
}
