package prob4;

public class DoublyLinkedList {

    Node header;
    DoublyLinkedList(){
        header = new Node();
    }
    //1. adds to the end of the list
    public void addLast(String item) {
        //implement
        Node newNode = new Node();
        newNode.value = item;
        if(header.next == null){
            newNode.previous = header;
            newNode.next = header.next;
            header.next = newNode;
        }
        else{
            Node currentNode = header.next;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.previous = currentNode;
        }
    }
    // 2. Remove by passing object
    public boolean remove(String item){
        //Implement
        if(header.next == null || item == null)
            return false;
        Node currentNode = header.next;
        while(currentNode != null){
            if(currentNode.value.equals(item)){
                currentNode.previous.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // 3. Remove the First Node

    public boolean removeFirst() {
        // Implement
        if(header.next == null)
            return false;
        header.next = header.next.next;
        return true;
    }

    // 4. Prints the list from last to first
    public void printReverse() {
        // Implement
        if(header.next == null){
            System.out.print("Empty List!");
            return ;
        }
        System.out.print("Reverse List: ");
        Node current = header.next;
        while(current.next != null){
            current = current.next;
        }
        while(current != header){
            System.out.print(current.value + " ");
            current = current.previous;
        }
        System.out.println();
    }
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        toString(sb, header);
        return sb.toString();

    }
    private void toString(StringBuilder sb, Node n) {
        if(n==null) return;
        if(n.value != null) sb.append(" " + n.value);
        toString(sb, n.next);
    }

    class Node {
        String value;
        Node next;
        Node previous;

        public String toString() {
            return value == null ? "null" : value;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast("Bob");
        list.addLast("Harry");
        list.addLast("Steve");
        System.out.println("Original: " + list);
        // Call all your implemented Methods
        list.addLast("Alex");
        list.addLast("Bishnu");
        list.addLast("Kheang");
        System.out.println("Add group 5 member to the list: " + list);
        list.printReverse();
        list.removeFirst();
        System.out.println("After Remove First Item: " + list);
        list.remove("Steve");
        System.out.println("After Remove Steve: " + list);
    }
}
