package Stack;


public class LeetCode1190_ReverseParentheses {
    static int i = 0;
    public static void main(String[] args) {
        String s1 = "(abcd)";
        String s2 = "(u(love)i)";
        String s3 = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s1));
        i = 0;
        System.out.println(reverseParentheses(s2));
        i =0;
        System.out.println(reverseParentheses(s3));
    }
    public static String reverseParentheses (String s){
        char[] ar = s.toCharArray();
        return helper(ar);
    }
    public static String helper(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }else if(s[i] == '('){
                i++;
                String st  = helper(s);
                sb.append(st);
            }else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}