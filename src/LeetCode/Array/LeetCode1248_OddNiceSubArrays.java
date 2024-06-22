package Array;

public class LeetCode1248_OddNiceSubArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2,1,1};
        int k1 = 3;
        int[] nums2 = {2,4,6};
        int k2 = 1;
        int[] nums3 = {2,2,2,1,2,2,1,2,2,2};
        int k3 = 2;
        System.out.println(numberOfSubArrays(nums1,k1));
        System.out.println(numberOfSubArrays(nums2,k2));
        System.out.println(numberOfSubArrays(nums3,k3));
    }

    private static int numberOfSubArrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int oddCount=0;
        int count=0;
        int temp=0;

        while(j<nums.length){
            if(nums[j]%2==1){
                oddCount++;
                temp=0;
            }
            while(oddCount==k){
                temp++;
                if(nums[i]%2==1){
                    oddCount--;
                }
                i++;
            }
            count+=temp;
            j++;
        }
        return count;
    }
}