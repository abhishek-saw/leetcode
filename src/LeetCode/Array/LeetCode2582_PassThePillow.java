package Array;

public class LeetCode2582_PassThePillow {
    public static void main(String[] args) {
        int n1 = 4;
        int pass1 = 5;
        int n2 = 3;
        int pass2 = 2;
        System.out.println(passThePillow(n1,pass1));
        System.out.println(passThePillow(n2,pass2));
    }

    private static int passThePillow(int n, int time) {
        int pos = 1;
        boolean dir = true;
        while (time>0){
            if(dir){
                pos++;
            }
            else {
                pos--;
            }
            if(pos==n){
                dir=false;
            }
            if(pos==1){
                dir=true;
            }
            time--;
        }
        return pos;
    }
}
