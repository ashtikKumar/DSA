package DSA.STACK;

import java.util.Scanner;

class StackUnderFlowException extends RuntimeException{
    public StackUnderFlowException(String e){
        super(e);
    }
}

class Stack {
    int stack[];
    int top;
    Stack(int n){
        stack = new int[n];
        top = -1;
    }

    void push(int ele) throws StackOverflowError{
        if(full()){
            throw new StackOverflowError("Stack Overflow !");
        } else {
            stack[++top] = ele;
            display();
        }
    }

    int pop() throws StackUnderFlowException{
        if(empty()){
            throw new StackUnderFlowException("Stack Underflow !");
        } else {
            return stack[top--];
        }
    }

    void display() throws StackUnderFlowException{
        if(empty()){
            throw new StackUnderFlowException("Stack is Empty !");
        } else {
            for(int i=0; i<=top; i++){
                System.out.print(stack[i]+" ");
            }
        }
    }

    int peek() throws StackUnderFlowException{
        if(empty()){
            throw new StackUnderFlowException("Stack is Empty !");
        } else {
            return stack[top];
        }
    }

    boolean empty(){
        if(top==-1)
            return true;
        return false;
    }

    boolean full(){
        if(top==stack.length-1)
            return true;
        return false;
    }
}

public class StackOps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Maximum capacity of Stack :");
        Stack stack = new Stack(sc.nextInt());

        do{
            System.out.println("---MENU---");
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Peek\n0. Exit");
            System.out.print("Enter your choice : ");
            try{
                switch(sc.nextInt()){
                    case 1:if(stack.full()) stack.push(0);
                        System.out.print("Enter element to push : ");
                        stack.push(sc.nextInt());
                        break;

                    case 2:System.out.print("Popped element :"+stack.pop());
                        break;

                    case 3:stack.display();
                        break;

                    case 4:System.out.print("Top element :"+stack.peek());
                        break;

                    case 0:System.out.println("Exiting...");
                        System.exit(0);

                    default:System.out.print("Invalid Choice !");
                }
            } catch(StackOverflowError e){
                System.out.println("Error : "+e.getMessage());
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Error :"+e.getMessage());
            } catch(Exception e){
                System.out.println("Error : "+e.getMessage());
            } finally{
                System.out.println("\n\nDo you want to continue ? (1/0) : ");
            } 
        } while(sc.nextInt()==1);
        System.out.println("Exiting...");
        sc.close();
    }
}