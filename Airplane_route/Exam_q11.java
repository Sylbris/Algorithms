import java.util.Arrays;

public class Exam_q11 {
    /**
     *  Exam 3.10.2017 , Q2
     *  Find LIS in a circular array.
     *  Find length of LIS
     */
    public static int LIS(int []arr,int startIndex,int EndIndex, int n){
        int [] t= new int [n];
        t[0]=arr[startIndex];
        int k=1;
        for(int i=startIndex+1;i<EndIndex;i++){
            int index = Arrays.binarySearch(t, 0, k, arr[i]);
            if(index < 0) index = -index - 1; // fix java's results
            if(index == k) k++;
            t[index]=arr[i];
        }
        System.out.println(Arrays.toString(t));
        return k;
    }

    /**
     *  The idea : double the array and the values.
     *  Use a window in the size of arr, and then check LIS of each window.
     *
     * @param arr
     * @return
     */
    public static int LIS_Circular(int []arr){
        int n=arr.length;
        int []help=new int[n];
        int [] t=new int[n*2];
        int maxLength=0;
        for(int i=0;i<t.length;i++){
            t[i]=arr[i%n];
        }
        //System.out.println(Arrays.toString(t));
        for(int i=0;i<n;i++){
           maxLength=Math.max(LIS(t,i,n+i,n),maxLength);
        }

        return maxLength;
    }
    public static int binarySearchBetween(int []arr, int end, int value) {// O(logn)
        /**
         if value<arr[0] the function returns zero
         if value>arr[end] the function returns end+1
         if arr[index-1] < value < arr[index]
         the function returns index
         */
        int low = 0, high = end;
        if (value<arr[0]) return 0;
        if (value>arr[end]) return end+1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (low == high) return low; // stop search
            else if (arr[middle] == value) return middle; //value was found
            else if (value < arr[middle]) high = middle; // value supposes in the left
            else low = middle + 1; // value supposes in the right
        }


        return -1;
    }
    public static void main(String[]args){
        int []arr={1,11,2,10,4,5,2,1};
        int []arr2={9,10,8,0,1,4,3,7};
        System.out.println(LIS_Circular(arr2));
    }
}
