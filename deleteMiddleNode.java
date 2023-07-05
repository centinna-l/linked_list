public class deleteMiddleNode {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        return head;
    }

    static void deleteMiddleNodeEx() {
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // delete the middle node
        prev.next = slow.next;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        deleteMiddleNode list = new deleteMiddleNode();
        head = null;
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.println("Original List:");
        list.display();

        list.deleteMiddleNodeEx();

        System.out.println("List after deleting the middle node:");
        list.display();
    }
}
