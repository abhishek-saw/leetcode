package HashMaps;

import java.util.HashMap;
import java.util.Objects;

public class LeetCode242_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String s1 = "aacc";
        String t1 = "ccac";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s1, t1));
        System.out.println(isAnagramBetter(s, t));
        System.out.println(isAnagramBetter(s1, t1));
    }

    private static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int [] array = new int[26];
        for (char chars: s.toCharArray()){
            array[chars-'a']++;
        }
        for (char chars: t.toCharArray()){
            array[chars-'a']--;
        }
        for (int count: array){
            if(count!=0){
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (int i = 0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
            }
            else {
                map1.put(s.charAt(i),1);
            }
            if(map2.containsKey(t.charAt(i))){
                map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
            }
            else {
                map2.put(t.charAt(i),1);
            }
        }
        for (int i = 0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i)) && map2.containsKey(s.charAt(i))){
                if(Objects.equals(map1.get(s.charAt(i)), map2.get(s.charAt(i)))){
                    continue;
                }
                else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

}