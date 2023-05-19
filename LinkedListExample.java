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

    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // point to the next header
        }
        System.out.println();
    }

    public void reverse() {

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
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
