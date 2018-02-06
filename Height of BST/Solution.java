import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
static int i=-1,max=0;
public static int getHeight(Node root){
     //Write your code here
       if(root.right==null && root.left==null)
       {  i++;
           if(i>max)
           {   
               max=i;
           }
          return -1;
       }
    i++;
       if(root.right==null)
      { 
        getHeight(root.left);
          i--;
      }
      else if(root.left==null)
      { 
        getHeight(root.right);
          i--;
      }
      else if(root.left!=null && root.right!=null)
      {
          getHeight(root.left);
          i--;
          getHeight(root.right);
          i--;
      }
       
       return max;
       
     }
 public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
	 public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}