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


    public static void main(String[] args) {
        int res = new Max().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(res);
    }
}
