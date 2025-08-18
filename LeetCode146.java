class LRUCache {
    class Node{
        int key,val;
        Node prev = null, next = null;
        Node(int k,int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
    private Map<Integer,Node> map;
    Node head = null,tail = null;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        map.remove(key);
        insertToHead(node);
        return node.val;       
    }
    
    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.size()>capacity){
            remove(map.get(tail.prev));
        }
        if(!map.containsKey(key)){
            map.put(key,node);
            insertToHead(node);
            return;
        }
        Node oldNode = map.get(key);
        remove(oldNode);
        map.remove(key);
        insertToHead(node);

    }
    private void insertToHead(Node node){
        map.put(node.key,node);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
