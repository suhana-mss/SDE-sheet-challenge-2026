/*
Question Link:
https://leetcode.com/problems/lfu-cache/

Question:
Design a Least Frequently Used (LFU) Cache.

If multiple keys have same frequency,
remove the Least Recently Used one.

All operations should work in O(1).
*/

class LFUCache {
        // Each cache entry
        class Node{
            int key;
            int value;
            int freq;
            Node prev;
            Node next;
            Node(int key, int value){
                this.key=key;
                this.value=value;
                // New node is used once during insertion.
                this.freq = 1;
            }
        }

        //new Doubly Linked List for each frequency
        class DLL{
            Node head;
            Node tail;
            int size;

            DLL(){
                head= new Node(-1,-1);
                tail= new Node(-1,-1);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            //Insert node right after head. New node becomes the Most Recently Used node among this frequency.
            void addFirst(Node node) {
                Node nextNode = head.next;

                head.next = node;
                node.prev = head;

                node.next = nextNode;
                nextNode.prev = node;

                size++;
            }

            //Remove any node in O(1). This is why we use a Doubly Linked List
            void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            //Node before tail is the Least Recently Used node of this frequency
            Node removeLast() {
                if(size == 0) {
                    return null;
                }
                Node node = tail.prev;
                remove(node);
                return node;
            }
        }

    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> freqMap;
    int capacity;
    int minFreq;
    //  smallest currently present in cache,needed because when cache is full,we must evict the least frequent node otherwise we'd have to search all frequencies

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        // Key not present
        if(!cache.containsKey(key)) {
            return -1;
        } 
        Node node = cache.get(key);
        updateFrequency(node); 
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }

        if(cache.containsKey(key)){
            Node node= cache.get(key);
            node.value=value;
            updateFrequency(node);
            return;
        }

        /*
            Cache is full.
            Remove: Least Frequently Used.
            If multiple nodes have same frequency,remove Least Recently Used.
        */
        if(cache.size() == capacity){
            DLL list= freqMap.get(minFreq);
            Node node= list.removeLast();
            cache.remove(node.key);
        }

        // Create new node.
        Node node = new Node(key, value);
        cache.put(key, node);
        //New node starts with frequency = 1
        DLL list = freqMap.getOrDefault(1, new DLL());
        list.addFirst(node);
        freqMap.put(1, list);
        minFreq = 1;
    }

    void updateFrequency(Node node){
        
        //Remove node from old frequency list
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        //If this was the only node having minimum frequency, then minimum frequency increases.
        if(oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Move node to new(next) frequency list
        // Increase node frequency.
        node.freq++;
        DLL newList =freqMap.getOrDefault(node.freq, new DLL());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */