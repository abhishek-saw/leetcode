package Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));
        int k = 3;
        rotate(array,k);
        System.out.println(Arrays.toString(array));
        int [] array1 = {1,2};
        int k1 =3;
        System.out.println(Arrays.toString(array1));
        rotate(array1,k1);
        System.out.println(Arrays.toString(array1));


    }
    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length<k){
            return;
        }
        reverseArray(nums,0,nums.length-1);
//        System.out.println(Arrays.toString(nums));
        reverseArray(nums,0,k-1);
//        System.out.println(Arrays.toString(nums));
        reverseArray(nums,k,nums.length-1);
    }

    private static void reverseArray(int[] array, int start, int end) {
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
