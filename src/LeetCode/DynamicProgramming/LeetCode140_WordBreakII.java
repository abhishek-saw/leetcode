package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode140_WordBreakII {
    static List<String> sentences = new ArrayList<>();

    public static void main(String[] args) {
        List<String> wordDict1 = new ArrayList<>(List.of("cat", "cats", "and", "sand", "dog"));
        String s1 = "catsanddog";
        List<String> wordDict2 = new ArrayList<>(List.of("apple", "pen", "applepen", "pine", "pineapple"));
        String s2 = "pineapplepenapple";
        List<String> wordDict3 = new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"));
        String s3 = "catsandog";
        System.out.println(wordBreakII(s1, wordDict1));
        System.out.println(wordBreakII(s2, wordDict2));
        System.out.println(wordBreakII(s3, wordDict3));
    }

    private static List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        sentences = new ArrayList<>();
        wordBreakHelper(words, s, 0, "");
        return sentences;
    }

    private static void wordBreakHelper(Set<String> words, String s, int i, String sentence) {
        if (i == s.length()) {
            sentences.add(sentence);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String word = s.substring(i, j + 1);
            if (words.contains(word)) {
                if (sentence.isEmpty()) {
                    wordBreakHelper(words, s, j + 1, sentence + word);
                } else {
                    wordBreakHelper(words, s, j + 1, sentence + " " + word);
                }
            }
        }
    }
}