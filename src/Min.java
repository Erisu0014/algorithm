import java.util.*;

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

    public int kthSmallest(int[][] matrix, int k) {
        /**
         * @Description // 378. 有序矩阵中第K小的元素
         * @Date 2020/7/2 16:36
         * @Param matrix
         * @param k
         * @return int
         **/
        int len = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != len - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * @Description //120. 三角形最小路径和 https://leetcode-cn.com/problems/triangle/
         * @Date 2020/7/14 8:18
         * @Param triangle
         * @return int
         **/
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 9};
        int[] b = new int[]{10, 11, 13};
        int[] c = new int[]{12, 13, 15};
        int k = 8;
        int[][] d = new int[][]{a, b, c};
        System.out.println(new Min().kthSmallest(d, k));
//        int i = new Min().minSubArrayLen(4, new int[]{1, 4, 4});
//        System.out.println(i);

    }
}
