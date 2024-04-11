package String;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
    }

    private static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int prev = s.length();
        int curr = s.length() -1;
        int answer = 0;
        while (curr>=0){
            if(prev==s.length()){
                answer +=map.get(s.charAt(curr));
            }
            else{
                if(map.get(s.charAt(curr))<map.get(s.charAt(prev))){
                    answer-=map.get(s.charAt(curr));
                }
                else {
                    answer+=map.get(s.charAt(curr));
                }
            }
            curr--;
            prev--;
        }
        return answer;
    }
}
