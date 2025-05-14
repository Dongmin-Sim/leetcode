import java.util.HashMap;
import java.util.Map;
class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            removeNode(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            removeNode(node);
            addFirst(node);
            return;
        }

        Node newNode = new Node(key, value);
        if (nodeMap.size() >= this.capacity) {
            Node last = tail.prev;
            removeNode(last);
            nodeMap.remove(last.key);
        }
        addFirst(newNode);
        nodeMap.put(key, newNode);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(){}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}