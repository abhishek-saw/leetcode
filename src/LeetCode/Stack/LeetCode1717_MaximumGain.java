package Stack;

import java.util.Stack;

public class LeetCode1717_MaximumGain {
    public static void main(String[] args) {
        String s1= "cdbcbbaaabab";
        int x1 = 4, y1 = 5;
        String s2 = "aabbaaxybbaabb";
        int x2 = 5, y2 = 4;
        String s3 = "paaaabdbabfbybbbtaaab";
        int x3 = 8132, y3 = 1776;
        System.out.println(maximumGain(s1, x1, y1));
        System.out.println(maximumGain(s2, x2, y2));
        System.out.println(maximumGain(s3, x3, y3));
    }

    private static int maximumGain(String s, int x, int y) {
        int countX = 0;
        int countY = 0;
        Stack<Character> stack = new Stack<>();
        if(x>y) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'b' && !stack.isEmpty()) {
                    if (stack.peek() == 'a') {
                        countX++;
                        stack.pop();
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else {
                    stack.add(s.charAt(i));
                }
            }
            System.out.println(stack);
            StringBuilder sNew = new StringBuilder();
            while (!stack.isEmpty()) {
                sNew.insert(0, stack.pop());
            }
            for (int i = 0; i < sNew.length(); i++) {
                if (sNew.charAt(i) == 'a' && !stack.isEmpty()) {
                    if (stack.peek() == 'b') {
                        countY++;
                        stack.pop();
                    } else {
                        stack.add(sNew.charAt(i));
                    }
                } else {
                    stack.add(sNew.charAt(i));
                }
            }
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a' && !stack.isEmpty()) {
                    if (stack.peek() == 'b') {
                        countY++;
                        stack.pop();
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else {
                    stack.add(s.charAt(i));
                }
            }
            System.out.println(stack);
            StringBuilder sNew = new StringBuilder();
            while (!stack.isEmpty()) {
                sNew.insert(0, stack.pop());
            }
            for (int i = 0; i < sNew.length(); i++) {
                if (sNew.charAt(i) == 'b' && !stack.isEmpty()) {
                    if (stack.peek() == 'a') {
                        countX++;
                        stack.pop();
                    } else {
                        stack.add(sNew.charAt(i));
                    }
                } else {
                    stack.add(sNew.charAt(i));
                }
            }
        }
        System.out.println(countX);
        System.out.println(countY);
        return x * countX + y * countY;
    }
}