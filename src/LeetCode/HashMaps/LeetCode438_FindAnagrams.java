package HashMaps;


import java.util.ArrayList;
import java.util.List;

public class LeetCode438_FindAnagrams {
    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        String s2 = "abab";
        String p2 = "ab";
        System.out.println(findAnagrams(s1,p1));
        System.out.println(findAnagrams(s2,p2));
        System.out.println(findAnagramsBetter(s1,p1));
        System.out.println(findAnagramsBetter(s2,p2));
    }

    private static List<Integer> findAnagramsBetter(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (p.length() > s.length()) {
            return anagrams;
        }
        int[] arraySWindow = new int[26];
        int[] arrayP = new int[26];
        for(char c : p.toCharArray()){
            arrayP[c-'a']++;
        }
        for(int i =0;i<p.length();i++){
            arraySWindow[s.charAt(i)-'a']++;
        }
        if(matches(arraySWindow,arrayP)){
            anagrams.add(0);
        }
        for (int j=p.length();j<s.length();j++){
            arraySWindow[s.charAt(j)-'a']++;
            arraySWindow[s.charAt(j- p.length())-'a']--;
            if(matches(arraySWindow,arrayP)){
                anagrams.add(j-p.length()+1);
            }
        }
        return anagrams;
    }

    private static boolean matches(int[] arraySWindow, int[] arrayP) {
        for(int i = 0;i<arrayP.length;i++){
            if(arrayP[i]!=arraySWindow[i]){
                return false;
            }
        }
        return true;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        for(int i = 0;i<s.length()-p.length()+1;i++){
            if(isAnagram(s.substring(i,i+p.length()),p)){
                anagrams.add(i);
            }
        }
        return anagrams;
    }

    private static boolean isAnagram(String s1, String t1) {
        int[] array = new int[26];
        for(char c: s1.toCharArray()){
            array[c-'a']++;
        }
        for(char c: t1.toCharArray()){
            array[c-'a']--;
        }
        for(int c : array){
            if(c!=0){
                return false;
            }
        }
        return true;
    }
}
