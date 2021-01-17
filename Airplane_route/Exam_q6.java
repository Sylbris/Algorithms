public class Exam_q6 {
    public class DoubleCycleLinkedList {
        public class NodeDouble {
            private int data;
            private NodeDouble next,prev;

            public NodeDouble(int data) {
                this.data = data;
                next = prev = null;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public NodeDouble getNext() {
                return next;
            }

            public void setNext(NodeDouble next) {
                this.next = next;
            }

            public NodeDouble getPrev() {
                return prev;
            }

            public void setPrev(NodeDouble prev) {
                this.prev = prev;
            }
    }
        private NodeDouble head,tail;

        public DoubleCycleLinkedList() {
            head = tail = null;
        }

        public void add(int data) {
            NodeDouble n = new NodeDouble(data);
            if(head == null) {
                head = tail = n;
                head.setNext(head);
                head.setPrev(head);
            }
            else {
                n.setNext(head);
                n.setPrev(tail);
                tail.setNext(n);
                head.setPrev(n);
                tail = n;
            }
        }

        public NodeDouble getHead() {
            return head;
        }

        @Override
        public String toString() {
            String ans = "[";
            NodeDouble n = head;
            while(n!= null && n != tail) {
                ans += n.getData() + ", ";
                n = n.getNext();
            }
            if(n == null) return ans + "]";
            return ans + tail.getData() + "]";
        }

    /**
     * Given a list , count the amount of cars.
     * Use only one pointer.
     * @param
     * @return
     */
    public int num_of_cars(DoubleCycleLinkedList list){
        NodeDouble start=list.getHead();
        int count=0;
        int count2=0;
        boolean flag=false;
        while(!flag){
            count=1;
            while (start.getData() != 'v') {
                count++;
                start= start.getNext();
            }
            start.setData('x');
            count2=count;
            while(count2>0){
                count--;
                start=start.getPrev();
            }
            if(start.getData()=='x') flag=true;
            start=start.getNext();
        }
        return count;
        }

    }
}
