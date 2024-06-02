package String;

public class LeetCode28_FirstOccurrence {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));
    }

    private static int strStr(String haystack, String needle) {
        for(int i =0;i<=haystack.length()-needle.length();i++){
            if(haystack.startsWith(needle, i)){
                return i;
            }
        }
        return -1;
    }
}
