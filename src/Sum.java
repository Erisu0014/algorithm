import java.lang.reflect.Array;
import java.util.*;
import java.util.*;

/**
 * @Description 一些求和问题
 * @Author alice
 * @Date 2020/6/22 8:38
 **/
public class Sum {

    public int[] twoNums(int[] nums, int target) {
        /**
         * @Description //两数之和问题，见https://leetcode-cn.com/problems/two-sum/
         * @Date 2020/6/22 8:52
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * @Description //两数相加 https://leetcode-cn.com/problems/add-two-numbers/
         * @Date 2020/6/23 17:20
         * @Param l1 倒序链表l1(2 -> 4 -> 3)
         * @param l2 倒序链表l2(5 -> 6 -> 4)
         * @return ListNode 7 -> 0 -> 8
         **/
        ListNode l = l1;
        ListNode r = l2;
        ListNode result = new ListNode();
        ListNode root = result;
        int carry = 0;
        while (l != null || r != null || carry != 0) {
            if (l == null) {
                l = new ListNode();
                l.val = 0;
                l.next = null;
            }
            if (r == null) {
                r = new ListNode();
                r.next = null;
                r.val = 0;
            }

            result.val = (l.val + r.val + carry) % 10;
            carry = (l.val + r.val + carry) / 10;
            l = l.next;
            r = r.next;
            if (l == null && r == null && carry == 0) {
                break;
            }
            result.next = new ListNode();
            result = result.next;
        }
        return root;

    }

    public int threeSumClosest(int[] nums, int target) {
        /**
         * @Description //最接近的三数之和 https://leetcode-cn.com/problems/3sum-closest/
         * @Date 2020/6/24 8:17
         * @Param nums 数组
         * @param target 目标值
         * @return int
         **/
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i;
            int m = l + 1;
            int r = nums.length - 1;
            while (m < r) {
                int now_sum = nums[l] + nums[m] + nums[r];
                if (Math.abs(sum - target) > Math.abs(now_sum - target)) {
                    sum = now_sum;
                }
                if (now_sum < target) {
                    m++;
                } else {
                    r--;
                }
                if (sum - target == 0) {
                    return sum;
                }
            }
        }
        return sum;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * @Description //63. 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/
         * @Date 2020/7/6 16:42
         * @Param obstacleGrid
         * @return int
         **/
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

    }

    public int[] divingBoard(int shorter, int longer, int k) {
        /**
         * @Description //面试题 16.11. 跳水板 https://leetcode-cn.com/problems/diving-board-lcci/
         * @Date 2020/7/8 15:46
         * @Param shorter
         * @param longer
         * @param k
         * @return int[]
         **/
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] a = new int[k];
        for (int i = 0; i <= k; i++) {
            a[i] = k * shorter + (longer - shorter) * i;
        }
        return a;
    }

    private int[] index;
    private int[] helper;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        index = new int[nums.length];
        helper = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        merge(nums, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            res.add(i, count[i]);
        }
        return res;
    }

    private void merge(int[] nums, int s, int e) {
        if (s == e || s > e) return;
        int mid = (s + e) >> 1;

        if (s < mid) {
            merge(nums, s, mid);
        }

        if (mid + 1 < e) {
            merge(nums, mid + 1, e);
        }

        int i = s, j = mid + 1;
        int hi = s;
        while (i <= mid && j <= e) {
            if (nums[index[i]] <= nums[index[j]]) {
                // 右侧出
                helper[hi++] = index[j++];
            } else {
                // 左侧出 计数
                count[index[i]] += e - j + 1;
                helper[hi++] = index[i++];
            }
        }

        while (i <= mid) {
            //左侧出
            helper[hi++] = index[i++];
        }

        while (j <= e) {
            // 右侧出
            helper[hi++] = index[j++];
        }

        for (int k = s; k <= e; k++) {
            index[k] = helper[k];
        }
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer num : nums) {
            output.add(num);
        }
        backtrack(nums.length, output, 0);
        return res;
    }

    public void backtrack(int n, ArrayList<Integer> output, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public int numTrees(int n) {
        /**
         * @Description //96. 不同的二叉搜索树 https://leetcode-cn.com/problems/unique-binary-search-trees/
         * @Date 2020/7/16 8:19
         * @Param n
         * @return int
         **/
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int waysToChange(int n) {
        /**
         * @Description //面试题 08.11. 硬币 https://leetcode-cn.com/problems/coin-lcci/
         * @Date 2020/7/17 16:49
         * @Param  * @param n
         * @return int
         **/
//        int[] coins = new int[]{1, 5, 10, 25};
//        int [][]dp=new int[4][n+1];
//        for (int i=0;i<)
        return 0;
    }


    public static void main(String[] args) {
//
//        int[][] obstacleGrid = new int[1][2];
//        obstacleGrid[0][0] = 1;
//        obstacleGrid[0][1] = 0;
//        new Sum().uniquePathsWithObstacles(obstacleGrid);

//        int[][] obstacleGrid = new int[1][2];
//        obstacleGrid[0][0] = 1;
//        obstacleGrid[0][1] = 0;
//        new Sum().uniquePathsWithObstacles(obstacleGrid);
//        int num = new Sum().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
//        System.out.println(num);
        new Sum().countSmaller(new int[]{5, 2, 6, 1});

//        new Sum().permute(new int[]{1,2,3});
    }
}
