package huang;
public class DumpMethods {
	public static ListNode deleteDuplication(ListNode pHead) {
		ListNode p = pHead;
		ListNode index = new ListNode(1);
		index.next = pHead;
		ListNode result = index;
		while (p != null) {
			if (p.next != null && p.next.val == p.val) {
				while (p.next != null && p.next.val == p.val) {
					p = p.next;
				}
				p = p.next;
				index.next = p;
			} else {
				index= index.next;
				p = p.next;
			}
		}
		return result.next;
	}
}