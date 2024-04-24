package String;

import java.util.HashMap;

public class FirstUnique {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqueChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int count =  map.get(s.charAt(i))+1;
                map.put(s.charAt(i),count);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }
        System.out.println(map);
        for(int i =0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] fre = new int[26];
        for(char c : arr) {
            fre[c-'a']++;
        }
        for(int i=0; i<len; i++) {
            if(fre[arr[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
