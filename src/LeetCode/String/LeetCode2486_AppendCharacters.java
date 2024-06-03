package String;

public class LeetCode2486_AppendCharacters {
    public static void main(String[] args) {
        String s1 = "coaching";
        String t1 = "coding";
        System.out.println(appendCharacters(s1,t1));
        String s2 = "abcde";
        String t2 = "a";
        System.out.println(appendCharacters(s2,t2));
        String s3 = "z";
        String t3 = "abcde";
        System.out.println(appendCharacters(s3,t3));
        String s4 = "coaching";
        String t4 = "coing";
        System.out.println(appendCharacters(s4,t4));
        String s5 = "coaching";
        String t5 = "caig";
        System.out.println(appendCharacters(s5,t5));
    }

    private static int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int start_s = 0;
        int start_t = 0;
        while (start_s<m && start_t<n){
            if(t.charAt(start_t)==s.charAt(start_s)){
                start_t++;
            }
            if (start_t == n) {
                return 0;
            }
            start_s++;
        }
        return n-start_t;
    }
}
