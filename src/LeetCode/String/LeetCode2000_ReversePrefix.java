package String;

public class LeetCode2000_ReversePrefix {
    public static void main(String[] args) {
        String word  = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));
    }
    public static String reversePrefix(String word, char ch) {
        int j = word.indexOf(ch);
        if (j != -1) {
            return new StringBuilder(word.substring(0, j + 1)).reverse() + word.substring(j + 1);
        }
        return word;
    }
}
