package Math;

public class LeetCode7_ReverseInteger {
    public static void main(String[] args) {
        int n1 = 1534236469;
        int n2 = -2147483412;
        System.out.println(reverse(n1));
        System.out.println(reverse(n2));
    }
    public static int reverse(int x) {
        long answer = reverseHelper(Math.abs(x));
        if(answer>=2147483647 || answer<-2147483646){
            return 0;
        }
        return (int) (x<0 ? -answer : answer);
    }

    private static long reverseHelper(int abs) {
       long answer = 0;
       while(abs>0){
           answer = 10*answer + abs%10;
           abs = abs/10;
       }

       return answer;
    }

}
