import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description 最大值问题
 * @Author alice
 * @Date 2020/6/29 8:21
 **/
public class Max {
    public int findKthLargest(int[] nums, int k) {
        /**
         * @Description //数组中的第K个最大元素 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
         * @Date 2020/6/29 8:21
         * @Param nums
         * @param k
         * @return int
         **/
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == nums.length - k) {
                return nums[index];
            }
            if (index < nums.length - k) {
                left = index + 1;
            }
            if (index > nums.length - k) {
                right = index - 1;
            }
        }

    }

    public int partition(int[] nums, int left, int right) {
        int middle = left;
        int pivot = nums[middle];
        while (left < right) {
            while (nums[right] >= pivot && left < right) {
                right--;
            }
            while (nums[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        nums[middle] = nums[left];
        nums[left] = pivot;
        return left;

    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int findLength(int[] A, int[] B) {
        /**
         * @Description // 718. 最长重复子数组 https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
         * @Date 2020/7/1 15:46
         * @Param A 数组A
         * @param B 数组B
         * @return int
         **/
        int[][] dp = new int[A.length + 1][B.length + 1];
        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    public String largestNumber(int[] nums) {
        /**
         * @Description //179. 最大数 https://leetcode-cn.com/problems/largest-number/
         * @Date 2020/7/17 11:25
         * @Param  * @param nums
         * @return java.lang.String
         **/
        List<String> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(String.valueOf(num));
        }
        numList.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        numList.forEach(sb::append);
        return sb.toString();
    }


    public static void main(String[] args) {
        int res = new Max().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(res);
    }
}
