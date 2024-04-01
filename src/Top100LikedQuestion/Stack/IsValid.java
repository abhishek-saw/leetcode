package Stack;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s  = "{}{}";
        System.out.println(isValid(s));
    }
    private static boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' ||c=='{' || c=='['){
                stack.push(c);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else {
                if (c == ')'  && stack.peek() =='('){
                    stack.pop();
                } else if (c == '}'  && stack.peek()=='{'){
                    stack.pop();
                } else if (c == ']'  && stack.peek()=='['){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
