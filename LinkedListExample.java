import java.util.Stack;

public class LinkedListExample {
    private Node head; // get the head

    public LinkedListExample() {
        this.head = null; // first initialization to null
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAfter(int key, int data) {
        Node newNode = new Node(data);

        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Insert a node before a given node
    public void insertBefore(int key, int data) {
        Node newNode = new Node(data);

        if (head != null && head.data == key) {
            newNode.next = head; // setting the new node to head of the node just before
            head = newNode;
            return;
        }

        Node current = head;
        while (current != null && current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete a node with a specific value
    public void deleteNode(int key) {
        // check if the head is not null and key is matching.
        // change the head of that element to the next.
        if (head != null && head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        // get the snap of first and last element
        while (current != null && current.data != key) {
            prev = current; // setting the node before the key to the head after the key
            current = current.next; // shifting
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    public void deleteMiddleNode() {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;

    }

    public void rotateCounterClockwise(int k) {
        if (head == null || head.next == null || k <= 0) {
            // Empty list, only one element, or invalid rotation
            return;
        }

        int length = 1;
        Node current = head;

        // Find the length of the linked list
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Adjust k to handle rotations greater than the length of the list
        k = k % length;

        if (k == 0) {
            // No rotation required
            return;
        }

        Node newHead = head;
        Node tail = current;

        // Find the new head and tail after rotation
        for (int i = 0; i < length - k - 1; i++) {
            newHead = newHead.next;
        }

        tail.next = head;
        head = newHead.next;
        newHead.next = null;
    }

    public void find(int key) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == key) {
                System.out.println(current.data + " Found at position " + (count + 1));
                return;
            }
            count++;
            current = current.next;
        }
        System.out.println("Data not Found");
    }

    public boolean isCircular() {
        if (head == null) {
            return true;
        }
        Node current = head;
        while (current != null && current != head) {
            current = current.next;
        }
        return current == head;
    }

    public void removeDuplicates() {
        Node current = head;
        if (head == null || head.next == null) {
            return;
        }
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    void removeNAfterMNodes(int m, int n) {
        Node current = head, temp = null;

        while (current != null) {
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return;
            }
            temp = current.next;
            for (int i = 1; i < n && temp != null; i++) {
                temp = temp.next;
            }
            current.next = temp;
            current = temp;
        }
    }

    void reverse() {
        Node p1 = null, p2 = head;
        while (p2 != null) {
            Node p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head = p1;
    }

    Node reverseAlternateNode(Node head, int k) {
        int count = 0;
        Node p1 = null, p2 = head;
        while (p2 != null && count < k) {
            Node p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            count++;
        }
        count = 0;
        while (p2 != null && count < k) {
            p2 = p2.next;
            count++;
        }
        if (p2.next != null) {
            p2.next = reverseAlternateNode(p2.next, k);
        }

        return head = p1;

    }

    boolean detectLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            while (fast == slow) {
                return true;
            }
        }
        return false;
    }

    int getNNodeFromEnd(int n) {
        Node slow = head, fast = head;
        // move n pointers ahead.
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    boolean isPalindrome() {
        Node current = head, temp = head;
        boolean check = false;
        Stack<Integer> stack = new Stack<>();
        while (current != null && current.next != null) {
            stack.push(current.data);
            current = current.next;
        }
        while (temp != null && temp.next != null) {
            int i = stack.pop();
            if (temp.data == i) {
                check = true;
            } else {
                check = false;
                break;
            }
            temp = temp.next;
        }
        return check;
    }

    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // point to the next header
        }
        System.out.println();
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null; // this is head set to null
    }
}
