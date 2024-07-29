package Stack;

import java.util.Stack;

public class LeetCode2390_RemoveStars {
    public static void main(String[] args) {
        String s1 = "leet**cod*e";
        String s2 = "erase*****";
        System.out.println(removeStars(s1));
        System.out.println(removeStars(s2));
    }

    private static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                stack.pop();
            }
            else {
                stack.add(s.charAt(i));
            }
        }
        String answer = "";
        while (!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        return answer;
    }
}
