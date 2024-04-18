package Array;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
        System.out.println(findMedianSortedArraysBetter(nums1,nums2));

    }
    public static double findMedianSortedArraysBetter(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return findMedianSortedArraysBetter(nums2, nums1);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] answer = mergeArray(nums1,nums2);
        System.out.println(Arrays.toString(answer));
        if(answer.length%2!=0){
            return answer[answer.length/2];
        }
        else {
            return (answer[answer.length/2] + answer[answer.length/2-1])/(2.0);
        }
    }
    private static int[] mergeArray(int[] nums1, int[] nums2) {
        int [] ans = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k] = nums1[i];
                i++;
            }
            else {
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            ans[k] = nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            ans[k] = nums2[j];
            j++;
            k++;
        }
        return ans;
    }
}
