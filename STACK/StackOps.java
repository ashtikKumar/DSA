package DSA.STACK;

import java.util.Scanner;

class Stack {
    int stack[];
    int top;
    Stack(){
        stack = new int[100];
        top = -1;
    }

    void push(int ele) throws StackOverflowError{
        if(top==stack.length-1){
            throw new StackOverflowError("Stack Overflow !");
        } else {
            stack[++top] = ele;
            display();
        }
    }

    int pop() throws ArrayIndexOutOfBoundsException{
        if(empty()){
            throw new ArrayIndexOutOfBoundsException("Stack Underflow !");
        } else {
            return stack[top--];
        }
    }

    void display() throws ArrayIndexOutOfBoundsException{
        if(empty()){
            throw new ArrayIndexOutOfBoundsException("Stack is Empty !");
        } else {
            for(int i=0; i<=top; i++){
                System.out.print(stack[i]+" ");
            }
        }
    }

    int peek() throws ArrayIndexOutOfBoundsException{
        if(empty()){
            throw new ArrayIndexOutOfBoundsException("Stack is Empty !");
        } else {
            return stack[top];
        }
    }

    boolean empty(){
        if(top==-1) return true;
        else return false;
    }
}

public class StackOps {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("---MENU---");
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Peek\n");
            System.out.print("Enter your choice : ");
            try{
                switch(sc.nextInt()){
                    case 1:System.out.println("Enter element to push : ");
                        stack.push(sc.nextInt());
                        break;

                    case 2:System.out.println("Popped element :"+stack.pop());
                        break;

                    case 3:stack.display();
                        break;

                    case 4:System.out.println("Top element :"+stack.peek());
                        break;

                    case 0:System.out.println("Exiting...");
                        break;

                    default:System.out.println("Invalid Choice !");
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
        sc.close();
    }
}