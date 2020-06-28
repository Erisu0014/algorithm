

/**
 * @author Erisu
 * @date 2020/6/27 15:29
 * @Description 不知道怎么分类
 * @Version 1.0
 **/
public class Weird {
    public int firstMissingPositive(int[] nums) {
        /**
         * @Description //缺失的第一个正数 https://leetcode-cn.com/problems/first-missing-positive/
         * @Date 2020/6/24 8:17
         * @Param nums 数组
         * @return int
         **/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
