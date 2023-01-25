import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue = null;

    Queue<Integer> cache = null;

    public MyStack() {
        queue = new LinkedList<>();
        cache = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (queue.isEmpty()) {
            return 0;
        }
        int len = queue.size();
        for (int i = 0; i < len - 1; i++) {
            cache.offer(queue.poll());
        }
        int res = queue.poll();
        while (!cache.isEmpty()) {
            queue.add(cache.poll());
        }
        return res;
    }

    public int top() {
        if (queue.isEmpty()) {
            return 0;
        }
        int len = queue.size();
        for (int i = 0; i < len - 1; i++) {
            cache.add(queue.poll());
        }
        int res = queue.poll();
        cache.add(res);
        while (!cache.isEmpty()) {
            queue.add(cache.poll());
        }
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */