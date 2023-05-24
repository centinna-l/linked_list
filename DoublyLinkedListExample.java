import java.util.Currency;

public class DoublyLinkedListExample {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null; // this is head set to null
            this.prev = null;
        }
    }

    private Node head; // reference to the starting node of the list.
    private Node tail; // reference to the last node of the list.

    public DoublyLinkedListExample() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(int key, int data) {
        if (isEmpty()) {
            System.out.println("List is empty. No elements to delete.");
            return;
        }
        Node new_node = new Node(data);

        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current != null) {
            Node temp = current.next;
            current.next = new_node;
            new_node.prev = current;
            new_node.next = temp;
        }
    }

    public void deleteAtBeginning() {
        if (isEmpty()) {
            System.out.println("List is empty. No elements to delete.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("List is empty. No elements to delete.");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteKey(int key) {
        if (isEmpty()) {
            System.out.println("List is empty. No elements to delete.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data == key) {
                if (current == head) {
                    deleteAtBeginning();
                    return;
                } else if (current == tail) {
                    deleteAtEnd();
                    return;
                } else {
                    current.prev.next = current.next;
                    System.out.println("current.prev.next.data " + current.prev.next.data);
                    current.next.prev = current.prev;
                    return;
                }
            }
            current = current.next;
        }

    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
