/*
Question Link:
https://leetcode.com/problems/lru-cache/

Question:
Design a Least Recently Used (LRU) Cache.

Operations:
get(key)
put(key, value)

Both should work in O(1).
*/

class LRUCache {

    // Doubly Linked List node
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        // Recently used, so move to front.
        deleteNode(node);
        insertAfterHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;

            // Recently used.
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size() == capacity){
                // Node before tail is least recently used.
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);

            // New node becomes most recently used.
            insertAfterHead(node);
        }
    }


    // Remove node from DLL.
    void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Insert node right after head.
    void insertAfterHead(Node node) {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */