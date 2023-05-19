public class Driver {
    public static void main(String[] args) {
        LinkedListExample linkedList = new LinkedListExample();

        linkedList.addNode(10);
        linkedList.addNode(20);
        linkedList.addNode(30);
        linkedList.addNode(40);

        System.out.println("Original linked list:");
        linkedList.display(); // Output: 10 20 30 40

        linkedList.insertAfter(20, 25);
        System.out.println("After inserting 25 after 20:");
        linkedList.display();

        linkedList.insertBefore(30, 28);
        System.out.println("After inserting 28 before 30:");
        linkedList.display();

        linkedList.reverse();
        System.out.println("Reversed");
        linkedList.display();

        // linkedList.deleteNode(40);
        // System.out.println("After deleting node with value 25:");
        // linkedList.display();

    }
}
