import java.util.Arrays;

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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dungeon[i][j + 1]);
                dp[i][j] = Math.min(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
