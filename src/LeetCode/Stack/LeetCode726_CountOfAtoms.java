package Stack;

import java.util.*;

public class LeetCode726_CountOfAtoms {
    public static void main(String[] args) {String formula1 = "H2O";
        String formula2 = "Mg(OH)2";
        String formula3 = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula1));
        System.out.println(countOfAtoms(formula2));
        System.out.println(countOfAtoms(formula3));
    }

    private static String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i<len){
            if(formula.charAt(i)=='('){
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i)==')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            } else {
                int start = i;
                i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);
                start = i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count);
            }
        }

        Map<String, Integer> result = stack.pop();
        List<String> elements = new ArrayList<>(result.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            int count = result.get(element);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}