package nowcoder;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，
 * 你能帮助他么？
 */
public class Solution42 {
    public String ReverseSentence(String str) {
        if (str==" ") return str;
        if (str.length() == 1 || str.length() == 0 || str == null) return str;
        String[] words = str.trim().split(" ");
        StringBuilder newSentence = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            newSentence.append(words[i] + " ");
        }
        newSentence.append(words[0]);
        return newSentence.toString();
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.ReverseSentence(" "));
    }
}
