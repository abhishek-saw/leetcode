package HashMaps;

import java.util.*;

public class LeetCode648_ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary1 = new ArrayList<>(List.of("cat","bat","rat"));
        String sentence1 = "the cattle was rattled by the battery";
        List<String> dictionary2 = new ArrayList<>(List.of("a","b","c"));
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary1,sentence1));
        System.out.println(replaceWords(dictionary2,sentence2));
        System.out.println(replaceWordsBetter(dictionary1,sentence1));
        System.out.println(replaceWordsBetter(dictionary2,sentence2));
//        System.out.println(replaceWordsTrie(dictionary1,sentence1));
//        System.out.println(replaceWordsTrie(dictionary2,sentence2));
    }

    private static String replaceWordsTrie(List<String> dictionary1, String sentence1) {
        return null;
    }
    private static String replaceWordsBetter(List<String> dictionary, String sentence) {
        String [] wordArray = sentence.split(" ");
        Set<String> dictionarySet = new HashSet<>(dictionary);
        System.out.println(dictionarySet);
        for(int i =0;i<wordArray.length;i++){
            wordArray[i] = findWord(wordArray[i],dictionarySet);
        }
        return String.join(" ",wordArray);
    }

    private static String findWord(String word, Set<String> dictionarySet) {
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictionarySet.contains(root)) {
                return root;
            }
        }
        return word;
    }

    private static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder answer = new StringBuilder();
        HashMap<String,Boolean> hashMap = new HashMap<>();
        for(String s : dictionary){
            hashMap.put(s,true);
        }
        String [] array = sentence.split(" ");
        System.out.println(Arrays.toString(array));
        System.out.println(hashMap);
        for (String s : array) {
            String word = getWord(s, hashMap);
            answer.append(word);
            answer.append(" ");
        }
        return answer.substring(0,answer.length()-1);
    }

    private static String getWord(String s, HashMap<String, Boolean> hashMap) {
        String words = "";
        for(char c : s.toCharArray()){
            words+=c;
            if(hashMap.containsKey(words)){
                return words;
            }
        }
        return words;
    }


}
