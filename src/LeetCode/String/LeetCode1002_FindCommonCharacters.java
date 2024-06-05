package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1002_FindCommonCharacters {
    public static void main(String[] args) {
        String [] wordss1 = {"bella","label","roller"};
        String [] wordss2 = {"cool","lock","cook"};
        System.out.println(commonChars(wordss1));
        System.out.println(commonChars(wordss2));
    }

    private static List<String> commonChars(String[] words) {
        List<String> output = new ArrayList<>();
        int[] arrays1 = new int[26];
        for (char c : words[0].toCharArray()){
            arrays1[c-'a']++;
        }
        System.out.println(Arrays.toString(arrays1));
        for(int i = 1;i<words.length;i++){
            int[] arrays2 = new int[26];
            for (char c : words[i].toCharArray()){
                arrays2[c-'a']++;
            }
            for(int j = 0;j<arrays2.length;j++){
                    arrays1[j] =Math.min(arrays1[j],arrays2[j]);
            }
        }
        System.out.println(Arrays.toString(arrays1));
        for(int m = 0;m<arrays1.length;m++){
            if(arrays1[m]!=0){
                for(int p = 0;p<arrays1[m];p++){
                    output.add(String.valueOf((char)(m+'a')));
                }
            }
        }
        return output;
    }
}
