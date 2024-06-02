package String;

public class LeetCode1404_NumStepsBinary {
    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "10";
        System.out.println(binaryToDecimal(1101));
        System.out.println("Steps : " + numSteps(s1));
        System.out.println(binaryToDecimal(10));
        System.out.println("Steps : " + numSteps(s2));
    }
    public static int binaryToDecimal(int n){
        int answer = 0;
        int power = 0;
        while (n>0){
            if(n%10==1) {
                answer += (int) Math.pow(2, power);
            }
            power++;
            n = n/10;
        }
        return answer;
    }
    private static int numSteps(String s) {
        int l = s.length()-1;
        int carry = 0;
        int count = 0;
        while (l>0){
            if(s.charAt(l) + carry -'0'== 0){
                carry =0;
                count++;
            }
            else if(s.charAt(l) + carry -'0'== 2){
                carry=1;
                count++;
            }
            else {
                carry=1;
                count+=2;
            }
            l--;
        }
        return carry==1 ? carry+count:count;
    }
}
