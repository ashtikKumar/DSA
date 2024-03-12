package DSA.QUEUE;

import java.util.Scanner;
import java.util.InputMismatchException;

class CQueue {
    int size, capacity, front, rear;
    int cqueue[];

    CQueue(int n){
        this.size = 0;
        this.capacity = n;
        this.front = -1;
        this.rear = -1;
        this.cqueue = new int[capacity];
    }

    boolean full(){
        return (rear+1)%capacity == front || rear==front-1;
    }
    boolean empty(){
        return size==0 || front>rear || (front==-1 && rear==-1);
    }

    void enqueue(int data) throws IllegalStateException{
        if(full()) throw new IllegalStateException("Queue Overflow !");
        cqueue[++rear] = data;
        if(front==-1) front=0;
        size++;
    }

    int dequeue() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue Underflow !");
        int x = cqueue[front];
        for(int i=0; i<size-1; i++){
            cqueue[i] = cqueue[i+1];
        }
        rear--;
        size--;
        if(front>rear) front=rear=-1;
        return x;
    }

    void display() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue is Empty !");
        System.out.print("Circular Queue: ");
        for(int i=0; i<size; i++){
            System.out.print(cqueue[i]+" ");
        }
        System.out.println();
    }

    int peek() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue is Empty !");
        System.out.print("Front Element: ");
        return cqueue[front];
    }
}

public class CircularQueue {
    int capacity;
    Scanner sc = new Scanner(System.in);
    CircularQueue(){
        while(true){
            try{
                System.out.print("Enter the capacity of the queue: ");
                capacity = sc.nextInt();
                if(capacity<=0) throw new InputMismatchException("Invalid Capacity !");
                break;
            } catch(InputMismatchException e){
                System.out.println(e.getMessage()+", Please enter valid capacity !\n");
            }
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        CQueue queue = new CQueue(q.capacity);

        do{
            System.out.println();
            System.out.println("--Menu--");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");

            try{
                switch(q.sc.nextInt()){
                    case 1:if(queue.full()) queue.enqueue(0);
                        System.out.print("Enter element to enter: ");
                        queue.enqueue(q.sc.nextInt());
                        break;

                    case 2:System.out.print(queue.dequeue());
                        break;

                    case 3:queue.display();
                        break;

                    case 4:System.out.println(queue.peek());
                        break;

                    case 0:System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:System.out.println("Invalid Choice !");
                }
            } catch(IllegalStateException e){
                System.out.println("Error: "+e.getMessage());
            } catch(Exception e){
                System.out.println("Unexpected Error: "+e.getMessage());
            } finally {
                System.out.print("Do you want to continue (1/0): ");
            }
        }while(q.sc.nextInt()==1);
    }
}
