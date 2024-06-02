package AllLeetCodeContest;


public class LeetCode3168 {
    public static void main(String[] args) {
        String s1 = "EEEEEEE";
        String s2 = "ELEELEELLL";
        String s3 = "ELELEEL";
        System.out.println(minimumChairs(s1));
        System.out.println(minimumChairs(s2));
        System.out.println(minimumChairs(s3));
    }

    private static int minimumChairs(String s) {
        int count = 0;
        int chair = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='E'){
                count++;
            }
            else {
                chair = Math.max(chair,count);
                count--;
            }
        }
        return Math.max(chair,count);
    }
}
