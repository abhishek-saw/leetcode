package String;

public class LeetCode43_MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        String num3 = "123";
        String num4 = "456";
        String num5 = "123456789";
        String num6 = "987654321";
        String num7 = "498828660196";
        String num8 = "840477629533";
        System.out.println(multiply(num1, num2));
        System.out.println(multiply(num3, num4));
        System.out.println(multiply(num5, num6));
        System.out.println(multiply(num7, num8));
    }

    private static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }
        int[] result = new int[m + n];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                product+= result[i+j+1] ;
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int r : result) {
            if (answer.isEmpty() && r == 0) {
                continue;
            }
            answer.append(r);
        }
        return answer.toString();
    }
}