class LRUCache {

    class Node {
        int key;
        int value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }


    private void makeMostRecentlyUsed(Node node) {
        remove(node);
        insertAtFront(node);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        makeMostRecentlyUsed(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            makeMostRecentlyUsed(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            insertAtFront(node);
            capacity--;
        }

        if (capacity < 0) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
            capacity++;
        }
    }
}
