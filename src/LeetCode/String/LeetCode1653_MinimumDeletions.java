package String;

import java.util.Stack;

public class LeetCode1653_MinimumDeletions {
    public static void main(String[] args) {
        String s1 = "aababbab";
        String s2 = "bbaaaaabb";
        String s3 = "bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba";
        System.out.println(minimumDeletionsStack(s1));
        System.out.println(minimumDeletionsStack(s2));
        System.out.println(minimumDeletionsStack(s3));
        System.out.println(minimumDeletionsCount(s1));
        System.out.println(minimumDeletionsCount(s2));
        System.out.println(minimumDeletionsCount(s3));
    }

    private static int minimumDeletionsCount(String s) {
        if(s.isEmpty() ||s.length()==1){
            return 0;
        }
        int count = Integer.MAX_VALUE;
        int countA = 0;
        int countB = 0;
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)=='a'){
                countA++;
            }
        }
        for(int i =0;i<s.length();i++) {
            if(s.charAt(i)=='a'){
                countA--;
            }
            count = Math.min(count,countA+countB);
            if(s.charAt(i)=='b'){
                countB++;
            }
        }
        return count;
    }

    private static int minimumDeletionsStack(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(c);
                continue;
            }
            if(stack.peek()=='b' && c=='a'){
                count++;
                stack.pop();
            }
            else {
                stack.add(c);
            }
        }
        return count;
    }
}
