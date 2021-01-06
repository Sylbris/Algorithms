
import java.util.LinkedList;
import java.util.*;

public class Cycle_detection {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
        public boolean hasNext(){
            if(next!=null)
                return true;
            else
                return false;
        }
    }


    /**
     * Check existence of cycle O(n)
     * @param robot
     */
    public static boolean check_cycle(Node robot){
        if(robot==null || !robot.hasNext())
            return false;
        Node slow=robot;
        Node fast=robot;
        boolean flag=true;

        while(flag){
            slow=slow.next;
            if(fast.hasNext())
                fast=fast.next.next;
            else
                return false;
            if(slow==null || fast==null)
                return false;
            if(slow.data==fast.data)
                return true;

        }
        return true;
    }

    /**
     * Returns a pointer to the meeting point. O(n)
     * @return
     */
    public static Node meeting_point(Node start){
    Node fast,slow;
    fast=start;
    slow=start;
    fast=fast.next.next;
    slow=slow.next;

    while(fast!=slow) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast.data == slow.data)
            return fast;
    }
    return fast;

    }


    public static void main(String []args){
        Node node=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);

        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(check_cycle(node));


    }
}
