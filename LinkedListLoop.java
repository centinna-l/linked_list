public class LinkedListLoop {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean hasLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true; // there is a loop detected
            }
        }
        return false;
    }

    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        Node loopStart = null;

        // Detect the loop and find the loop start point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopStart = slow;
                break;
            }
        }
        if (loopStart != null) {
            int loopLength = 1;
            Node temp = loopStart;

            while (temp.next != loopStart) {
                temp = temp.next;
                loopLength++;
            }

            Node ptr1 = head;
            Node ptr2 = head;
            for (int i = 0; i < loopLength; i++) {
                ptr2 = ptr2.next;
            }

            while (ptr2 != ptr1) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            while (ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            ptr2.next = null;
        }
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next; // point to the next header
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // Creating a loop

        if (hasLoop(head)) {
            System.out.println("Loop Detected");
            System.out.println("Removing Loop");
            removeLoop(head);
            display(head);
        } else {
            System.out.println("No Loop detected");
        }

    }
}
