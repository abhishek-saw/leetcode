package Array;

public class LeetCode11_MaxArea {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
        System.out.println(maxAreaBetter(nums));
    }

    private static int maxAreaBetter(int[] height) {
        int area = 0 ;
        int start = 0;
        int end = height.length-1;
        while(start<end) {
            int min = Math.min(height[end],height[start]);
            int minArea = (end-start)*min;
            area = Math.max(minArea, area);
//            if(height[end]<height[start]){
//                end--;
//            }
//            else{
//                start++;
//            }
            while(start<end && height[start]<=min){
                start++;
            }
            while(start<end && height[end]<=min){
                end--;
            }
        }
        return area;
    }
    private static int maxArea(int[] height) {
        int area = 0;
        for(int i =0;i< height.length-1;i++){
            int minArea = 0;
            for(int j =1;j< height.length;j++){
                minArea = Math.abs((j-i)*(Math.min(height[j],height[i])));
            }
            if(minArea>=area){
                area = minArea;
            }
        }
        return area;
    }

}
