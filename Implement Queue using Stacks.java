class MyQueue {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
