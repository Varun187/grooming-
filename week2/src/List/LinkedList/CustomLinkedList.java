package List.LinkedList;

class CustomLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(T val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(T val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(T val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    public T deleteFirst() {
        if (size == 0)
            throw new ListIsEmptyException("List is empty cannot remove the element");
        T val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public T deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);
        T val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public T delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = getNode(index - 1);
        T val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteByValue(T Value) {
        int index = find(Value);
        delete(index);
        return index;
    }

    public int find(T value) {
        Node node = head;
        int index = -1;
        while (node != null) {
            index++;
            if (node.value == value) {
                return index;
            }
            node = node.next;
        }
        return index;
    }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public T get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void reverse() {
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);

        list.deleteFirst();
        list.display();

        System.out.println(list.find(3));

        CustomLinkedList<String> stringList = new CustomLinkedList<>();
        stringList.insertLast("A");
        stringList.insertLast("B");
        stringList.insertLast("C");

        stringList.display();
    }
}