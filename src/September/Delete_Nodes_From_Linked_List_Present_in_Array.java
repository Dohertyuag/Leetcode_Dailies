package September;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.



Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:



Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:



Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:

No node has value 5.

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
 */

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


public class Delete_Nodes_From_Linked_List_Present_in_Array {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> valuesToRemove = new HashSet<>();
        for (int n : nums) valuesToRemove.add(n);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;

        while(current.next != null) {
            if(valuesToRemove.contains(current.next.val)) {
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }

        }

        return dummyHead.next;
    }

    public void driver(int[][] n) {
        for (int i = 0; i < n.length; i += 2) {
//            System.out.println(Arrays.deepToString(n));
            System.out.println("nums: " + Arrays.toString(n[i]) + " \thead: " + Arrays.toString(n[i + 1]));
            ListNode head = arrayToListNode(n[i + 1]);
            System.out.println("head: ");
            printListNode(head);

            ListNode modifiedHead = modifiedList(n[i], head);
            System.out.println("modifiedList: ");
            printListNode(modifiedHead);

        }
    }

    public void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public ListNode arrayToListNode(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
