import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 最小值问题
 * @Author alice
 * @Date 2020/6/28 9:32
 **/
public class Min {
    public int minSubArrayLen(int s, int[] nums) {
        /**
         * @Description //209. 长度最小的子数组 https://leetcode-cn.com/problems/minimum-size-subarray-sum/
         * @Date 2020/6/28 9:33
         * @Param s 7
         * @param nums [2,3,1,2,4,3]
         * @return int 2 子数组 [4,3] 是该条件下的长度最小的连续子数组。
         **/
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }


    public static void main(String[] args) {
        int i = new Min().minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println(i);
    }
}
