import java.util.*;

class StackSolution {
    public boolean isValid1(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public boolean isValid(String s) {
        byte[] bytes = s.getBytes();
        Stack<Character> stack = new Stack<>();
        for (byte b : bytes) {
            if (b == '(') {
                stack.push('(');
            } else if (b == '[') {
                stack.push('[');
            } else if (b == '{') {
                stack.push('{');
            } else if (stack.isEmpty() || stack.peek() != b) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty() || deque.peek() != s.charAt(i)) {
                deque.push(s.charAt(i));
            } else {
                deque.pop();
            }
        }
        System.out.println(deque.toString());
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        return sb.toString();
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int a = deque.pop();
                int b = deque.pop();
                deque.push(a + b);
            } else if (s.equals("-")) {
                int a = deque.pop();
                int b = deque.pop();
                deque.push(b - a);
            } else if (s.equals("*")) {
                int a = deque.pop();
                int b = deque.pop();
                deque.push(a * b);
            } else if (s.equals("/")) {
                int a = deque.pop();
                int b = deque.pop();
                deque.push(b / a);
            } else {
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void removeFirst(int val) {
            if (!deque.isEmpty() && val == deque.getFirst()) {
                // deque.removeFirst();
                deque.poll();
            }
        }

        void addLast(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(val);
        }

        int getFirst() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.addLast(nums[i]);
        }
        res[num++] = myQueue.getFirst();
        for (int i = k; i < nums.length; i++) {
            myQueue.removeFirst(nums[i - k]);
            myQueue.addLast(nums[i]);
            res[num++] = myQueue.getFirst();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[0];
        }
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            if (entry.getValue() > pq.peek()[1]) {
                pq.poll();
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        StackSolution solution = new StackSolution();
    }
}