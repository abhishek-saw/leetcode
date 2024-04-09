package Array;

public class MoveZero {
    public static void main(String[] args) {
        int [] array = {0,1,0,3,12};
        for(Integer integer:array){
            System.out.print(integer + " ");
        }
        System.out.println();
        moveZero(array);
        for(Integer integer:array){
            System.out.print(integer + " ");
        }
    }

    private static void moveZero(int[] array) {
        int zero = 0;
        int index = 0;
        while(index<array.length){
            if(array[index]!=0){
                int temp = array[zero];
                array[zero] = array[index];
                array[index] = temp;
                zero++;
            }
            index++;
        }
    }
}
