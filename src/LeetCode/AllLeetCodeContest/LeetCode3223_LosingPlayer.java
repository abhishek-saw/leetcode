package AllLeetCodeContest;

public class LeetCode3223_LosingPlayer {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(losingPlayer(x, y));
        int x1 = 2;
        int y1 = 7;
        System.out.println(losingPlayer(x1, y1));
        int x2 = 4;
        int y2 = 11;
        System.out.println(losingPlayer(x2, y2));
        int x3 = 2;
        int y3 = 8;
        System.out.println(losingPlayer(x3, y3));

    }

    private static String losingPlayer(int x, int y) {
        int winner = 1;
        while (x>0 && y>0){
            if(y>=4){
                x--;
                y-=4;
                winner++;
            }
            else {
                break;
            }

        }
        return winner%2==0? "Alice" :"Bob";
    }
}
