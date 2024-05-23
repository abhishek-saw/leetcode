package Array;

import java.util.Arrays;

public class Heights {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));
    }

    private static int heightChecker(int[] heights) {
        int[] arrangement = new int[heights.length];
        System.arraycopy(heights,0,arrangement,0,heights.length);
        Arrays.sort(arrangement);
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(arrangement));
        int count =0;
        for(int i = 0;i<heights.length;i++){
            if(heights[i]!=arrangement[i]){
                count++;
            }
        }
        return count;
    }
}