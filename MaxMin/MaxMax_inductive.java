import java.util.Stack;

public class MaxMax_inductive {
    public class Node{
        int num;
        Stack<Integer> st;
        Node next,prev;

        public Node(int num,Node next,Node prev){
            this.num=num;
            st=new Stack<>();
            this.next=next;
            this.prev=prev;
        }
        public Node(int num){
            this.num=num;
            st=new Stack<>();
            next=null;
            prev=null;
        }
    }
    public void maxMax2LinkedList(int []arr){
        Node head=new Node(arr[0]);
        Node n=head;
        for(int i=1;i<arr.length;i++){
            n.next=new Node(arr[i],null,n);
            n=n.next;
        }
        head.prev=n;
        n.next=head;
        int size=arr.length;
        Node n1=head;
        Node n2=head.next;
        while(size>1){
            n2=n1.next;
            if(n1.num<n2.num) {
                n2.st.push(n1.num);
                n1.prev.next=n2;
                n2.prev=n1.prev;
                n1=n2.next;
            }
            else { //n1>n2
                n1.st.push(n2.num);
                n1.next=n2.next;
                n2.next.prev=n1;
                n1=n2.next;
            }
            size--;
        }
        int max1=n1.num;
        int max2=max_value_inStack(n1.st);
        System.out.println("Max 1 is : "+ max1 + "Max 2 is "+ max2);
    }
    public int max_value_inStack(Stack<Integer> st){
        int max=st.pop();
        while(!st.isEmpty()){
            max=Math.max(st.pop(),max);
        }
        return max;
    }
}
