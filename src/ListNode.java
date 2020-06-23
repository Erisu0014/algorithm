/**
 * @Description 链表
 * @Author alice
 * @Date 2020/6/23 16:50
 **/
class ListNode {
    Integer val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x){
        val=x;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this.next;
    }
}
