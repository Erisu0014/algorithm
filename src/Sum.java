import java.util.HashMap;
import java.util.Map;

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
         * @Date  2020/6/23 17:20
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

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
//        ListNode l1 = l.setNext(new ListNode(4));
//        ListNode l2 = l1.setNext(new ListNode(3));
        ListNode r = new ListNode(5);
//        ListNode r1 = r.setNext(new ListNode(6));
//        ListNode r2 = r1.setNext(new ListNode(4));
        new Sum().addTwoNumbers(l, r);
    }
}
