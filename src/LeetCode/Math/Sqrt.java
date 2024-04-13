package Math;

public class Sqrt {
    public static void main(String[] args) {
        int n = 2147395600;
        System.out.println(sqrt(n));
    }

    private static int sqrt(int x) {
        if(x==0){
            return 0;
        }
        int start = 1;
        int end = x;
        int ans = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(x/mid==mid){
                return mid;
            }
            else if(x/mid>mid){
                start = mid+1;
                ans = mid;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
}
