package String;

public class LeetCode443_StringCompression {
    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        char[] chars4 = {'a', 'b', 'c'};
//        System.out.println(compress(chars1));
//        System.out.println(compress(chars2));
//        System.out.println(compress(chars3));
        System.out.println(compress(chars4));

    }

    private static int compress(char[] chars) {
        if (chars.length == 0 || chars.length == 1) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        char c = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (c != chars[i]) {
                stringBuilder.append(c);
                if (count > 1) {
                    stringBuilder.append(count);
                }
                c = chars[i];
                count = 1;
                continue;
            }
            count++;
        }
        stringBuilder.append(c);
        if (count > 1) {
            stringBuilder.append(count);
        }

        char[] chars1 = new char[stringBuilder.length()];
        for (int i = 0; i < chars1.length; i++) {
            chars[i] = stringBuilder.charAt(i);
        }
        System.out.println(chars);
        return stringBuilder.length();
    }
}