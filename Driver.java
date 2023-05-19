public class Driver {
    public static void main(String[] args) {
        LinkedListExample linkedList = new LinkedListExample();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);

        System.out.println("Original linked list:");
        linkedList.display();

        // Delete the Middle Node
        linkedList.deleteMiddleNode();
        System.out.println("Deleting the Middle Node");
        linkedList.display();

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

    }
}
