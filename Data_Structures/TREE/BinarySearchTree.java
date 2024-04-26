package DSA.Data_Structures.TREE;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node root;

    void insert(Node node, int data){
        if(data<=node.data){
            if(node.left!=null){
                insert(node.left,data);
            }else{
                node.left = new Node(data);
            }
        }else{
            if(node.right!=null){
                insert(node.right,data);
            }else{
                node.right = new Node(data);
            }
        }


    }
}
