package DSA.QUEUE;

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
        return (rear+1)%capacity == front || rear == front-1;
    }
    boolean empty(){
        return size==0 || front>rear || (front==-1 && rear==-1);
    }

    void enqueue(int data) throws IllegalStateException{
        if(full()) throw new IllegalStateException("Queue Overflow !");
        queue[++rear] = data;
        if(front==-1) front=0;
        size++;
    }

    int dequeue() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue Underflow !");
        int x = queue[front];
        for(int i=0; i<size-1; i++){
            queue[i] = queue[i+1];
        }
        rear--;
        size--;
        if(front>rear) front = rear = -1;
        return x;
    }

    void display() throws IllegalStateException{
        if(empty()) throw new IllegalStateException("Queue is EMPTY !");
        for(int i=0; i<size; i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }
}

public class QueueOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("--Menu--");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            System.out.print("Enter Choice :");

            try{
                switch(sc.nextInt()){
                    case 1:if(queue.full()) queue.enqueue(0);
                        System.out.print("Enter element to enter :");
                        queue.enqueue(sc.nextInt());
                        break;

                    case 2:System.out.print("Dequeued element :");
                        System.out.println(queue.dequeue());
                        break;

                    case 3:if(!queue.empty()) System.out.print("Queue : ");
                        queue.display();
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
        }while(sc.nextInt()==1);
        System.out.println("Exiting...");
        sc.close();
    }
}