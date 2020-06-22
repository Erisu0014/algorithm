import java.util.HashMap;
import java.util.Map;

/**
 * @Description 数字和问题
 * @Author alice
 * @Date 2020/6/22 8:38
 **/
public class NumSum {

    public int[] twoNums(int[] nums, int target) {
        /**
         * @Description //两数之和问题，见https://leetcode-cn.com/problems/two-sum/
         * @Date  2020/6/22 8:52
         * @Param nums
         * @param target 目标值
         * @return int[]
         **/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
