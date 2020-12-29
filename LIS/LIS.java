public class LIS {
    /**
     * In order to get LIS we get our array, convert
     * @param arr
     * @return
     */
    public static int LISLength(int [] arr) {// O(n*logn)
        int size = arr.length;
        int[] t=new int[size]; // help array
        t[0] = arr[0];
        int lis = 0;
        for (int i = 0;i<size;i++) {
            int index = binarySearchBetween(t, lis, arr[i]);//search each element
            t[index] = arr[i];
            if (index > lis) lis++;
        }
            return lis + 1; //add a first element
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
}
