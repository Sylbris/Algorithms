import java.util.Stack;

public class MaxMax_recursive {
    public class Node{
        int num;
        Stack<Integer> st;
        public Node(int num){
            this.num=num;
            st=new Stack<>();
        }

        public void max(int []arr){
            Node [] help_arr=new Node[arr.length];
            for(int i=0;i<arr.length;i++){
                Node node=new Node(arr[i]);
                help_arr[i]=node;
            }
            int index=max2(help_arr,0,help_arr.length-1);
            int max1=help_arr[index].num;
            int max2=max_value_inStack(help_arr[index].st);
            System.out.println("Max 1 is "+ max1 + "Max 2 is  "+ max2);
        }

        /**
         * return maximum in stack
         * @param st
         * @return
         */
        public int max_value_inStack(Stack<Integer> st){
            int max=st.pop();
            while(!st.isEmpty()){
                max=Math.max(st.pop(),max);
            }
            return max;
        }
        /**
         * Function to use MergeSort to determine the max.
         * returns the index in the array with highest value and also inserts to its stack
         * All the values of which Max_2 is preset.
         * @param arr
         * @param low
         * @param high
         * @return
         */
        public int max2(Node []arr, int low, int high){
            if(low<high){
                int index=0;
                int middle=(low+high)/2;
                int i=max2(arr,low,middle);
                int j=max2(arr,middle+1,high);
                if(arr[i].num>arr[j].num){ //when were left with 2 elements
                    arr[i].st.push(arr[j].num);
                    index=i;
                }
                else{
                    arr[j].st.push(arr[i].num);
                    index=j;
                }
                return index;
            }
            else {
                return low;
            }

        }


    }

}
