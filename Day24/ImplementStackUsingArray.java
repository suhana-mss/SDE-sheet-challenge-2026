class myStack {
    int[] arr;
    int top;
    int size;

    public myStack(int n) {
        size=n;
        arr=new int[size];
        top=-1;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top==size-1;
    }

    public void push(int x) {
        if(isFull()){
            return;
        }
        arr[++top]=x;
    }

    public void pop() {
        if(isEmpty()){
            return;
        }
        top--;
    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }
}