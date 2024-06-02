package Array;


public class LeetCode1608_SpecialArray {
    public static void main(String[] args) {
        int [] nums1 = {3,5};
        int [] nums2 = {0};
        int [] nums3 = {0,4,3,0,4};
        System.out.println(specialArray(nums1));
        System.out.println(specialArray(nums2));
        System.out.println(specialArray(nums3));
        System.out.println(specialArrayBetter(nums1));
        System.out.println(specialArrayBetter(nums2));
        System.out.println(specialArrayBetter(nums3));
    }

    private static int specialArrayBetter(int[] nums) {
        int[] freq = new int[nums.length+1];
        for(Integer integer:nums){
            if(integer>=freq.length){
                freq[freq.length-1]++;
            }
            else {
                freq[integer]++;
            }
        }
        int sum = 0;
        for(int i = freq.length-1;i>0;i--){
//             freq[i]+=sum;
//            sum = freq;
            sum += freq[i];
            if(i== sum){
                return i;
            }
        }
        return -1;
    }
    private static int specialArray(int[] nums) {
        int answer = -1;
        for(int i =0;i<nums.length+1;i++){
            int count = 0;
            for (int num : nums) {
                if (num >= i) {
                    count++;
                }
            }
            if (count==i){
                answer = count;
            }
        }
        return answer;
    }
}
