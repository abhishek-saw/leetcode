package BackTracking;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode17_LetterCombinations {
    public static void main(String[] args) {
     String digits = "23";
        List<String> answer1 = letterCombinations(digits);
        List<String> answer2 = letterCombinationsBetter(digits);
        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        } else {
            return letterCombinationsHelper(digits);
        }
    }
    private static List<String> letterCombinationsHelper(String digits) {
            if(digits.isEmpty()){
                return List.of(new String[]{""});
            }
            String[] options = getOption(digits.charAt(0));
            List<String> smallAnswer = letterCombinationsHelper(digits.substring(1));
            List<String> answer = new ArrayList<>();
            for (String s : smallAnswer) {
                for (String option : options) {
                    answer.add(option + s);
                }
            }
            return answer;
        }
    private static String[] getOption(char c) {
        if(c=='2'){
            return new String[]{"a","b","c"};
        }
        else if(c=='3'){
            return new String[]{"d","e","f"};
        }
        else if(c=='4'){
            return new String[]{"g","h","i"};
        }
        else if(c=='5'){
            return new String[]{"j","k","l"};
        }
        else if(c=='6'){
            return new String[]{"m","n","o"};
        }
        else if(c=='7'){
            return new String[]{"p","q","r","s"};
        }
        else if(c=='8'){
            return new String[]{"t","u","v"};
        }
        else if(c=='9'){
            return new String[]{"w","x","y","z"};
        }
        else {
            return new String[]{""};
        }
    }
    private static List<String> letterCombinationsBetter(String digits){
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }
    private static void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
        if (next_digits.isEmpty()) {
            output.add(combination);
        } else {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, next_digits.substring(1), phone_map, output);
            }
        }
    }
}