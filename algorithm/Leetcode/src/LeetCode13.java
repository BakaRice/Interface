class LeetCode13 {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') sum += 1000;
            if (s.charAt(i) == 'D') sum = sum + 500;
            if (s.charAt(i) == 'C') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        sum = sum + 400;
                        i++;

                    } else if (s.charAt(i + 1) == 'M') {
                        sum = sum + 900;
                        i++;

                    }else
                        sum = sum + 100;
                } else
                    sum = sum + 100;
            }
            if (s.charAt(i) == 'L') sum = sum + 50;
            if (s.charAt(i) == 'X') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        sum = sum + 40;
                        i++;

                    } else if (s.charAt(i + 1) == 'C') {
                        sum = sum + 90;
                        i++;

                    }else
                        sum = sum + 10;
                } else
                    sum = sum + 10;
            }
            if (s.charAt(i) == 'V') sum = sum + 5;
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'V') {
                        sum = sum + 4;
                        i++;

                    } else if (s.charAt(i + 1) == 'X') {
                        sum = sum + 9;
                        i++;

                    }else
                        sum = sum + 1;
                } else
                    sum = sum + 1;
            }
        }
        return sum;
    }
//另一种小想法
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.print(leetCode13.romanToInt("MMMCC"));
    }
}