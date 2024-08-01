package String;

public class LeetCode2678_CountSeniors {
    public static void main(String[] args) {
        String [] details1 = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        String [] details2 = {"1313579440F2036","2921522980M5644"};
        System.out.println(countSeniors(details1));
        System.out.println(countSeniors(details2));
    }

    private static int countSeniors(String[] details) {
        int count = 0;
        for(String s : details){
            String str = s.substring(11,13);
            int number = 10*(str.charAt(0)-'0') +str.charAt(1)-'0' ;
            if(number>60){
                count++;
            }
        }
        return count;
    }
}
