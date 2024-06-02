package Array;

public class LeetCode204_CountPrimes {
    public static void main(String[] args) {
        int n  = 858232;
        System.out.println(countPrimes(n));
    }

    private static int countPrimes(int n) {
        int count = 0;
        if(n<=2){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for(int i=3; i<n; i+=2){
            isPrime[i] = true;
        }
        isPrime[2] = true;
        for(int i=3; i*i<n; i+=2){
            if(isPrime[i]){
                for(int j=i*i; j<n; j+=2*i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}