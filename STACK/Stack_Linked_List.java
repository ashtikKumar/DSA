package DSA.STACK;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.System;

class StackNode{
    int data;
    StackNode next;

    StackNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class Stack_Linked_List {
    private StackNode head;

    StackNode push(int x, StackNode head){
        StackNode ele = new StackNode(x);
        StackNode temp = head;
        if(head==null){
            head = ele;
        }
        else{
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = ele;
        }
        return head;
    }

    StackNode pop(StackNode head) throws NoSuchElementException{
        if(length(head)<1){
            throw new NoSuchElementException("Stack is Empty !");
        }
        StackNode temp = head;
        if(length(head)==1){
            head = temp.next;
            return head;
        }
        while(temp.next.next!=null){
            temp = temp.next;
        }
        System.out.println("Element popped : "+temp.next.data);
        temp.next = null;
        display(head);
        return head;
    }

    int length(StackNode head){
        StackNode temp = head;
        int c = 0;
        if(head == null) return 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }

    int peek(StackNode head){
        StackNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp.data;
    }

    void display(StackNode head){
        StackNode temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack_Linked_List stack = new Stack_Linked_List();
        stack.head = null;

        do{
            try{
                System.out.println("---MENU---");
                System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display");
                System.out.print("Enter your choice :");
                switch(sc.nextInt()){
                    case 1:System.out.println("Enter element to push : ");
                        stack.head = stack.push(sc.nextInt(), stack.head);
                        break;

                    case 2:stack.head = stack.pop(stack.head);
                        break;

                    case 3:System.out.println("Top element :"+stack.peek(stack.head));
                        break;

                    case 4:System.out.println("Stack :");
                        stack.display(stack.head);
                        break;

                    case 0:System.out.println("Exiting...");
                        System.exit(0);

                    default:System.out.println("Invalid Choice !");
                }
            } catch(NoSuchElementException e){
                System.out.println("Error :"+e.getMessage());
            } catch(Exception e){
                System.out.println("Unexpected Error :"+e.getMessage());
            } finally {
                System.out.print("\nDo you want to continue (1/0) :");
            }
        }while(sc.nextInt()==1);
        System.out.println("Exiting...");
        sc.close();
    }
}
