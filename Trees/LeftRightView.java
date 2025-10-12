import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class LeftRightView {
    static class Node {
        int d;
        Node left,right;
        Node(int val){
            this.d=val;
            this.left=null;
            this.right=null;

        }
    }
    public static ArrayList<Integer> leftview(Node root){
        ArrayList<Integer> a=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(i==0) a.add(cur.d);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            
        }
        return a;
    } 
    public static ArrayList<Integer> rightview(Node root){
        ArrayList<Integer> a=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(i==size-1) a.add(cur.d);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            
        }
        return a;
    } 
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node (3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        System.out.println(leftview(root));
        System.out.println(rightview(root));
    }
}
