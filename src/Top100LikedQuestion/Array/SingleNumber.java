package Array;

public class SingleNumber {
    public static void main(String[] args) {
        int [] array = {2,2,1};
        System.out.println(singleNumber(array));
    }

    private static int singleNumber(int[] array) {
        int ans = 0;
        for(Integer integer: array){
            ans = ans^integer;
        }
        return ans;
    }
}
