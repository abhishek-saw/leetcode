package String;


public class LeetCode151_ReverseWordsString {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "   hello world  ";
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }

    private static String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!=' ') {
                word.append(s.charAt(i));
            }
            else if(!word.isEmpty()) {
                answer.insert(0, word + " ");
                word = new StringBuilder();
            }
            else {
                word = new StringBuilder();
            }
        }
        if(!word.isEmpty()) {
            answer.insert(0, word + " ");
        }
        return answer.substring(0,answer.length()-1);
    }
}
