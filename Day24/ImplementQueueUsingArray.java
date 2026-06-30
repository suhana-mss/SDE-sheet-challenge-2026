class myQueue {
    int[] arr;
    int size;
    int front;
    int rear;
    int count;

    public myQueue(int n) {
        size = n;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void enqueue(int x) {
        if (isFull()) return;

        rear = (rear + 1) % size;
        arr[rear] = x;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) return;

        front = (front + 1) % size;
        count--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }
}