package HashMaps;


import java.util.HashMap;

public class LeetCode560_SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] num1 = {1,1,1};
        int k1 = 2;
        int[] num2 = {1,2,3};
        int k2 = 3;
        int[] num3 = {3,4,7,-2,2,1,4,2};
        int k3 = 7;
//        System.out.println(subArraySum(num1,k1));
//        System.out.println(subArraySum(num2,k2));
        System.out.println(subArraySum(num3,k3));
    }

    private static int subArraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num  : nums) {
            sum += num;
            if (hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            if(hashMap.containsKey(sum)){
                hashMap.put(sum,hashMap.get(sum)+1);
            }
            else {
                hashMap.put(sum,1);
            }
        }
        return count;
    }
}