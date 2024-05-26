/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Map to store the mapping between original nodes and their copies
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node newHead = null;

        // First pass: create copies of all the nodes and store them in the map
        while (curr != null) {
            Node temp = new Node(curr.val);
            map.put(curr, temp);
            if (newHead == null) {
                newHead = temp;
                prev = newHead;
            } else {
                prev.next = temp;
                prev = temp;
            }
            curr = curr.next;
        }

        // Second pass: assign the next and random pointers for the copied nodes
        curr = head;
        Node newCurr = newHead;
        while (curr != null) {
            newCurr.random = (curr.random == null) ? null : map.get(curr.random);
            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead; 
    }
}