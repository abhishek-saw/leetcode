package String;

public class LeetCode344_ReverseString {
    public static void main(String[] args) {
        char [] s = {'h','e','l','o'};
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while (start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
