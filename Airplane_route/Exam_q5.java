import java.util.Arrays;

public class Exam_q5 {
    /**
     * Given an array we need to find the median of the array.
     * It is enough to calculate the the median of the 1st 64 elements.
     * O(1)
     * @param arr
     * @return
     */
    public int findMedian(int []arr){
        int max=arr[0];
        for(int i=1;i<64&&i<arr.length;i++){
            if(max<arr[i]){
                arr[i]=max;
            }
        }
        return max;
    }

    /**
     * Given 2 sorted arrays of same size find their median.
     *
     * @param A
     * @param B
     * @return
     */
    public static int [] median_of_sorted_arr(int [] A, int [] B) {
        int[] C = new int[A.length];
        int n = A.length;
        for (int i = 0; i < C.length; i++) {
            C[i] = Math.max(A[i], B[n - 1 - i]);
        }
        return C;
    }

    /**
     * Given k arrays of same size return their median.
     * @param A
     * @return
     */
    public static int [] median_of_sorted_k_arrays(int [] A){
        return null;
    }

    public static void main(String[]args){
        int[] A={1,3,4,9};
        int[] B={2,5,6,8};
        System.out.println(Arrays.toString(median_of_sorted_arr(A,B)));
        int[] C={1,2,5,6};
        int[] D={7,8,9,11};
        System.out.println(Arrays.toString(median_of_sorted_arr(C,D)));
    }
}
