public class KthSmallestAndLargestBST {
static class Node{
    int val;
    Node left,right;
    Node(int v){
        this.val=v;
        this.left=null;
        this.right=null;
    }

}   
static int countsmall=0;
static int anssmall=-1;
static int countlarge=0;
static int anslarge=-1;
public static void kthsmallest(Node root,int k){
    if(root==null) return;
    kthsmallest(root.left, k);
    countsmall++;
    if(countsmall==k){
        anssmall=root.val;
    }
    kthsmallest(root.right, k);

}
public  static void kthlargest(Node root,int k){
    if(root==null) return;
    kthlargest(root.right, k);
    countlarge++;
    if(countlarge==k){
        anslarge=root.val;
    }
    kthlargest(root.left, k);

}
public static void main(String[] args) {
    Node root=new Node(10);
    root.left=new Node(7);
    root.right=new Node(13);
    root.left.left=new Node(6);
    root.left.right=new Node(8);
    root.right.left=new Node(11);
    root.right.right=new Node(14);
    int a=3;
    kthsmallest(root,a);
System.out.println(anssmall);
kthlargest(root, a);
System.out.println(anslarge);
}

}
