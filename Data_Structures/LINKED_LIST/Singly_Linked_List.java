package DSA.Data_Structures.LINKED_LIST;
import java.util.InputMismatchException;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Singly_Linked_List {
    Node head;

    int length(Node head){
        int c = 0;
        Node temp = head;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }

    Node in_at_beg(int data, Node head) throws IllegalAccessException{
        Node temp = new Node(data);
        if(head==null){
            head=temp;
        } else {
            temp.next = head;
            head = temp;
        }
        System.out.println("Node Inserted at Beginning !");
        display(head);
        return head;
    }

    Node in_at_end(int data, Node head) throws IllegalAccessException{
        Node temp = new Node(data);
        if(head==null){
            head=temp;
        } else {
            Node curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = temp;
        }
        System.out.println("Node Inserted at End");
        display(head);
        return head;
    }

    Node in_at_pos(int data, int pos, Node head) throws IllegalAccessException {
        if(pos<1 || pos>length(head)+1){
            throw new IllegalAccessException("Invalid Position !");
        }
        Node temp = new Node(data);

        if(head==null){
            head=temp;
        } else if(pos==1){
            temp.next = head;
            head = temp;
        } else {
            Node curr = head;
            for(int i=1; i<pos-1 && curr!=null; i++){
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
        System.out.println("Node Inserted at specified Position");
        display(head);
        return head;
    }

    void display(Node head)throws IllegalAccessException{
        if(head==null){
            throw new IllegalAccessException("List is Empty!");
        }
        System.out.print("Linked List: ");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    Node deleteFirst(Node head) throws IllegalAccessException {
        if(head==null){
            throw new IllegalAccessException("List is empty !");
        }
        head = head.next;
        System.out.println("First Node deleted");
        return head;
    }

    Node deleteLast(Node head) throws IllegalAccessException {
        if(head==null){
            throw new IllegalAccessException("List is empty !");
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        System.out.println("Last Node deleted");
        return head;
    }

    Node delete(int pos, Node head) throws IllegalAccessException{
        if(head==null){
            throw new IllegalAccessException("List is empty !");
        }
        if(pos>length(head)){
            throw new IllegalAccessException("Invalid Position ! list has "+length(head)+" elements.");
        }
        if(pos<1){
            throw new IllegalAccessException("Invalid Position !");
        }
        if(pos==1){
            head = head.next;
        } else {
            Node temp = head;
            for(int i=1; i<pos-1 && temp!=null; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        System.out.println("Node deleted from specified Position !");
        return head;
    }

    int search(Node head, int x) throws IllegalAccessException {
        if(head==null) throw new IllegalAccessException("List is Empty !");
        Node temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            if(x==temp.data){
                return c;
            }
            temp = temp.next;
        }
        return -1;
    }

    Node reverse(Node head) throws IllegalAccessException {
        if(head==null) throw new IllegalAccessException("List is empty !");
        Node prev=null, curr=head, Next=null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = Next;
        }
        head = prev;
        System.out.print("Reversed List: ");
        display(head);
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singly_Linked_List list = new Singly_Linked_List();
        list.head = null;
        do{
            try{
                System.out.println("\n=---MENU---=");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at End");
                System.out.println("3. Insertion at Position");
                System.out.println("4. Delete from Beginning");
                System.out.println("5. Delete from End");
                System.out.println("6. Delete from Position");
                System.out.println("7. Reverse");
                System.out.println("8. Display");
                System.out.println("9. Search");
                System.out.println("0. Exit");
                System.out.print("\nEnter Choice: ");
                switch(sc.nextInt()){
                    case 1:System.out.println("\nInsert at the Beginning");
                        System.out.print("Enter Element: ");
                        list.head = list.in_at_beg(sc.nextInt(),list.head);
                        break;

                    case 2:System.out.println("\nInsert at the End");
                        System.out.print("Enter Element: ");
                        list.head = list.in_at_end(sc.nextInt(),list.head);
                        break;

                    case 3:System.out.println("\nInsert at a Position");
                        System.out.print("Enter Element and Position: ");
                        list.head = list.in_at_pos(sc.nextInt(), sc.nextInt(), list.head);
                        break;

                    case 4:list.head = list.deleteFirst(list.head);
                        break;

                    case 5:list.head = list.deleteLast(list.head);
                        break;

                    case 6:if(list.head!=null){
                            System.out.println("\nDelete a Node from a Position");
                            System.out.print("Enter Position: ");
                            list.head = list.delete(sc.nextInt(),list.head);
                        }
                        else throw new IllegalAccessException("List is Empty !");
                        break;

                    case 7:list.head=list.reverse(list.head);
                        break;

                    case 8:list.display(list.head);
                        break;

                    case 9:System.out.print("Enter Element to search: ");
                        int pos = list.search(list.head, sc.nextInt());
                        if(pos==-1) System.out.println("Element is not in the list");
                        else System.out.println("Element is found at position: "+pos);
                        break;

                    case 0:System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:System.out.println("Invalid Choice !");
                        continue;
                }
            } catch(IllegalAccessException e){
                System.out.println("Error: "+e.getMessage());
            } catch(InputMismatchException e){
                System.out.println("Wrong Input! Error: "+e.getMessage());
                sc.next();
            } catch(Exception e){
                System.out.println("Unexpected Error! "+e.getMessage());
                sc.next();
            } finally {
                System.out.print("\nDo you want to continue? (1/0): ");
            }
        }while(sc.nextInt()==1);
        System.out.println("Exiting...");
        sc.close();
    }
}
