class maxHeap {
    
    ArrayList<Integer> heap;

    public maxHeap() {
        heap=new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);
        heapifyUp(heap.size()-1);
    }

    public void pop() {
        if (heap.size() == 0) return;
        int last = heap.size() - 1;
        swap(0, last);
        heap.remove(last);
        if (heap.size() > 0) {
            heapifyDown(0);
        }
    }
    
    public int peek() {
        if(heap.size()==0) return -1;
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
    
    private void heapifyUp(int i){
        while(i>0){
            int parent=(i-1)/2;
            if(heap.get(parent)<heap.get(i)){
                swap(parent,i);
                i=parent;
            }else{
                break;
            }
            
        }
    }
    
    private void heapifyDown(int i){
        int size=heap.size();
        while(true){
            int l=2*i+1;
            int r=2*i+2;
            int largest=i;
              if (l< size && heap.get(l) > heap.get(largest)) {
                largest = l;
            }
            if (r< size && heap.get(r) > heap.get(largest)) {
                largest = r;
            }
            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }
    private void swap(int i,int j){
        int t=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,t);
    }
}