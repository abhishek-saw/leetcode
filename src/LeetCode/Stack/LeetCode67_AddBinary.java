package Stack;

public class LeetCode67_AddBinary {
    public static void main(String[] args) {
        String a1 = "11", b1 = "1";
        String a2 = "1010", b2 = "1011";
        String a3 = "1", b3 = "111";
        String a4 = "100", b4 = "110010";
        String a5 = "101111",b5 = "10";
        String a6 = "110010",b6 = "10111";
        System.out.println(addBinary(a1,b1));
        System.out.println(addBinary(a2,b2));
        System.out.println(addBinary(a3,b3));
        System.out.println(addBinary(a4,b4));
        System.out.println(addBinary(a5,b5));
        System.out.println(addBinary(a6,b6));
    }

    private static String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        char carry = '0';
        int m = a.length() - 1;
        int n = b.length() - 1;

        while (m >= 0 && n >= 0) {
            char c1 = a.charAt(m--);
            char c2 = b.charAt(n--);
            if (carry == '1') {
                if (c1 == '1' && c2 == '1') {
                    answer.insert(0, '1');
                } else if (c1 == '0' && c2 == '0') {
                    answer.insert(0, '1');
                    carry = '0';
                } else {
                    answer.insert(0, '0');
                }
            } else {
                if (c1 == '1' && c2 == '1') {
                    answer.insert(0, '0');
                    carry = '1';
                } else if (c1 == '0' && c2 == '0') {
                    answer.insert(0, '0');
                } else {
                    answer.insert(0, '1');
                }
            }
        }

        while (m >= 0) {
            char c1 = a.charAt(m--);
            if (c1 == '1' && carry == '1') {
                answer.insert(0, '0');
            } else if (c1 == '0' && carry == '0') {
                answer.insert(0, '0');
            } else {
                answer.insert(0, '1');
                carry = '0';
            }
        }

        while (n >= 0) {
            char c1 = b.charAt(n--);
            if (c1 == '1' && carry == '1') {
                answer.insert(0, '0');
            } else if (c1 == '0' && carry == '0') {
                answer.insert(0, '0');
            } else {
                answer.insert(0, '1');
                carry = '0';
            }
        }

        if (carry == '1') {
            answer.insert(0, '1');
        }

        return answer.toString();
    }
}