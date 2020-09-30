import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {
        int[] ints = {10, 27, 28, 29, 29, 30,38};
        System.out.println(Arrays.toString(ints));
        int i = binary(ints, 2);
        System.out.println(i);
//        int i1 = binaryLastValue(29, ints);
//        System.out.println(i1);
//        int i2 = binaryEqAndLessValue(29,ints);
//        System.out.println(i2);
    }

    public static int binary(int[] nums, int K){
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == K){
                return mid;
            }else if (nums[mid] < K){
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return -1;
    }
}
