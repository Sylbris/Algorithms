public class Exam_q4 {
    /**
     * Given an array of numbers, return the length increasing subsequence.
     * We assume no duplicates in array and array size is bigger than 2.
     * O(n*log2n)
     * @param arr
     * @return
     */
    public int LIS(int []arr){
        int n=arr.length;
        int [] help=new int[n];
        help[0]=arr[0];
        int lis=0;
        for(int i=1;i<n;i++){
            //Do search to find the index in the help array.
            int index=binarySearchBetween(help,lis,arr[i]);
            help[index]=arr[i];
            //If we couldn't find a place for it in the array.
            if(index>lis) lis++;
        }
        return lis+1;
    }
    public static int binarySearchBetween(int []arr, int end, int value){
        /**
         if value<arr[0] the function returns zero
         if value>arr[end] the function returns end+1
         if arr[index-1] < value < arr[index]
         the function returns index
         */
        int low = 0, high = end;
        if (value<arr[0]) return 0;
        if (value>arr[end])  return end+1;
        while (low <=high){
            int middle = (low + high)/2;
            if (low == high) {// stop search
                return low;
            }
            else {
                if (arr[middle] == value){//value was found
                    return middle;
                }
                if (value < arr[middle]){// value is supposed in the left
                    high = middle;
                }
                else{// value suppose is supposed in the right
                    low = middle+1;
                }
            }
        }
        return -1;
    }
}
