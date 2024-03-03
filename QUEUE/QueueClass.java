package DSA.QUEUE;

import java.util.Queue;
import java.util.LinkedList;
public class QueueClass {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.peek());
        
        queue.add(40);
        System.out.println(queue);
        
    }
}
