package String;

public class LeetCode192_IsSubsequence {
    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(isSubsequence(s1,t1));
        System.out.println(isSubsequence(s2,t2));
    }

    private static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return true;
        }
        int start = 0;
        for(int i =0;i<t.length();i++){
            if(s.charAt(start)==t.charAt(i)){
                start++;
            }
            if(start==s.length()){
                return true;
            }
        }
        return false;
    }
}
