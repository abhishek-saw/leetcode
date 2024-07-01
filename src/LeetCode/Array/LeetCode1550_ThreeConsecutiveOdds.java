package Array;

public class LeetCode1550_ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int [] arr1 = {2,6,4,1};
        int [] arr2 = {1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr1));
        System.out.println(threeConsecutiveOdds(arr2));
    }

    private static boolean threeConsecutiveOdds(int[] arr) {
        int idx = 0;
        while (idx<arr.length-2){
            if(arr[idx]%2!=0){
                if(arr[idx+1]%2!=0){
                    if(arr[idx+2]%2!=0){
                        return true;
                    }
                    else {
                        idx+=3;
                    }
                }
                else {
                    idx += 2;
                }
            }
            else {
                idx++;
            }
        }
        return false;
    }
}
