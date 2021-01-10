package review.一月.array;


/**
 *
 **/
public class _11_盛最多水的容器 {

    /**
     * 这一题高水位，我们可以用两个指针分别从左右两边去做抉择，
     * 我们假设长h 宽:k 因为我们的宽是不断的缩小的，所以我们在缩短的途中要选择比较高的水位，去让其最大化
     *
     **/
    public int maxArea(int[] height) {

        if (height == null || height.length == 0){
            return 0;
        }

        int left = 0 , right = height.length -1;
        int res = 0;

        while (left < right){

            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));

            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }

        return res;
    }
}
