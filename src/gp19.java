import java.util.Stack;

public class gp19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    Stack<ListNode> stack = new Stack<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;

    // Push all nodes into the stack while traversing the list.
    while (current != null) {
      stack.push(current);
      current = current.next;
    }

    // Pop n nodes from the stack.
    for (int i = 0; i < n; i++) {
      stack.pop();
    }

    // Remove the nth node from the end.
    ListNode prev = stack.peek();
    prev.next = prev.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    gp19 gp = new gp19();
    // Create a sample linked list: 1->2->3->4->5
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    // Set the value of n
    int n = 2;

    // Call the removeNthFromEnd method
    ListNode newHead = gp.removeNthFromEnd(head, n);

    // Print the modified linked list
    ListNode current = newHead;
    while (current != null) {
      System.out.print(current.val + "->");
      current = current.next;
    }
    System.out.println("null");
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}