public class Driver {
    public static void main(String[] args) {
        LinkedListExample linkedList = new LinkedListExample();
        DoublyLinkedListExample doublyLinkedList = new DoublyLinkedListExample();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);

        System.out.println("Original linked list:");
        linkedList.display();

        linkedList.removeNAfterMNodes(2, 2);
        linkedList.display();

        // // Delete the Middle Node
        // linkedList.deleteMiddleNode();
        // System.out.println("Deleting the Middle Node");
        // linkedList.display();

        // linkedList.insertAfter(20, 25);
        // System.out.println("After inserting 25 after 20:");
        // linkedList.display();

        // linkedList.insertBefore(30, 28);
        // System.out.println("After inserting 28 before 30:");
        // linkedList.display();

        // linkedList.reverse();
        // System.out.println("Reversed");
        // linkedList.display();

        // linkedList.deleteNode(40);
        // System.out.println("After deleting node with value 25:");
        // linkedList.display();

        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(6);
        System.out.println("Original Doubly linked list:");
        doublyLinkedList.display();

        // doublyLinkedList.deleteKey(3);
        // System.out.println("Doubly linked list:");
        // doublyLinkedList.display();

        doublyLinkedList.insertAfter(50, 100);
        System.out.println("Doubly linked list:");
        doublyLinkedList.display();
    }
}
