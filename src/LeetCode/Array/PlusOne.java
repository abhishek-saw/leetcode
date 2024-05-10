package Array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOneBetter(digits1)));
        System.out.println(Arrays.toString(plusOneBetter(digits2)));
        System.out.println(Arrays.toString(plusOneBetter(digits3)));
        System.out.println(Arrays.toString(plusOne(digits1)));
        System.out.println(Arrays.toString(plusOne(digits2)));
        System.out.println(Arrays.toString(plusOne(digits3)));
    }

    private static int[] plusOneBetter(int[] digits) {
        for( int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length-1;
        if(digits[n]+1>9){
            return plusOneHelper(digits);
        }
        else {
            digits[n]++;
            return digits;
        }
    }
    private static int[] plusOneHelper(int[] digits) {
        int n = digits.length-1;
        int carry = 0;
        int smallCarry = 0;
        for(int i=n;i>=0;i--){
            carry = (digits[i]+1)/10;
            if(carry==1){
                smallCarry =0;
                smallCarry++;
                digits[i] = (digits[i]+1)%10;
            }
            else {
                digits[i] +=smallCarry;
                break;
            }
        }
        if(carry==1){
            int[] temp = digits;
            digits = new int[digits.length+1];
            digits[0] = 1;
            System.arraycopy(temp, 0, digits, 1, digits.length - 1);
        }
        return digits;
    }
}
