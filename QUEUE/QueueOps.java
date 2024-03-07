package DSA.QUEUE;

import java.util.InputMismatchException;
import java.util.Scanner;

class Queue{
    int size, capacity, front, rear;
    int queue[];

    Queue(int n){
        this.size=0;
        this.capacity=n;
        this.front=-1;
        this.rear=-1;
        this.queue = new int[capacity];
    }

    boolean full(){
        return size==capacity;
    }
    boolean empty(){
        return size==0 || (front==-1 && rear==-1);
    }

    void enqueue(int data) throws IllegalStateException{
        if(full()) throw new IllegalStateException("Queue Overflow !");
        queue[++rear] = data;
        if(front==-1) front=0;
        size++;
    }

    int dequeue() throws IllegalStateException{
        if(empty()){
            if(full()) throw new IllegalStateException("No More Operations can be performed !");
            else throw new IllegalStateException("Queue Underflow !");
        }
        int x = queue[front++];
        int y = front -1;
        queue[y] = 0;
        if(front>rear) front = rear = -1;
        System.out.print("Dequeued Element: ");
        return x;
    }

    int peek() throws IllegalStateException {
        if(empty()) throw new IllegalStateException("Queue is empty !");
        int x = queue[front];
        System.out.print("Front element: ");
        return x;
    }

    void display() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue is EMPTY !");
        for(int i=front; i<size; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}

public class QueueOps {
    int capacity;
    Scanner sc = new Scanner(System.in);
    QueueOps(){
        while(true){
            try{
                System.out.print("Enter the capacity of the Queue :");
                capacity = sc.nextInt();
                if(capacity<=0) throw new InputMismatchException("Invalid Capacity");
                break;
            } catch(InputMismatchException e){
                System.out.println("Error: "+e.getMessage()+", please enter valid capacity !\n");
            }
        }
    }
    public static void main(String[] args) {
        QueueOps q = new QueueOps();
        Queue queue = new Queue(q.capacity);
        do{
            System.out.println("--Menu--");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("0. Exit");
            System.out.print("Enter Choice :");

            try{
                switch(q.sc.nextInt()){
                    case 1:if(queue.full()) queue.enqueue(0);
                        System.out.print("Enter element to enter :");
                        queue.enqueue(q.sc.nextInt());
                        break;

                    case 2:System.out.println(queue.dequeue());
                        break;

                    case 3:if(!queue.empty()) System.out.print("Queue : ");
                        queue.display();
                        break;

                    case 4:System.out.println(queue.peek());
                        break;

                    case 0:System.out.println("Exiting...");
                        System.exit(0);

                    default:System.out.print("Invalid Choice !");
                }
            } catch(IllegalStateException e){
                System.out.println("Error :"+e.getMessage());
            } catch(Exception e){
                System.out.println("Unexpected Error :"+e.getMessage());
            } finally {
                System.out.print("Do you want to continue (1/0) ?");
                System.out.println();
            }
        }while(q.sc.nextInt()==1);
        System.out.println("Exiting...");
        q.sc.close();
    }
}