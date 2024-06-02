package String;



public class LeetCode979_EqualSubstring {
    public static void main(String[] args) {
        String s  = "abcd";
        String t1 = "bcdf";
        String t2 = "cdef";
        String t3 = "acde";
        int maxCost1 = 3;
        int maxCost2 = 3;
        int maxCost3 = 0;
        System.out.println(equalSubstringBetter(s,t1,maxCost1));
        System.out.println(equalSubstringBetter(s,t2,maxCost2));
        System.out.println(equalSubstringBetter(s,t3,maxCost3));
        String s4 = "krrgw";
        String t4 = "zjxss";
        int maxCost4 = 19;
        System.out.println(equalSubstringBetter(s4,t4,maxCost4));
    }
    private static int equalSubstringBetter(String s, String t, int maxCost){
        int n = s.length();
        int l = 0;
        int r = 0;
        int currCost = 0;
        int maxLength = 0;
        while (r<n){
            currCost+=Math.abs(s.charAt(r)-t.charAt(r));
            if (currCost>maxCost){
                currCost-=Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
            maxLength = Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
    private static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int substring = 0;
        for(int i =0;i<n;i++) {
            int cost = maxCost;
            int small = 0;
            for (int j = i; j < n; j++) {
                int diff = Math.abs(s.charAt(j) - t.charAt(j));
                if (diff <= cost) {
                    cost -= diff;
                    small++;
                } else {
                    break;
                }
            }
            substring = Math.max(substring,small);
        }
        return substring;
    }
}
