public class Exam_q2 {
    /**
     * Given an array find the maximum difference in an array.
     * Were going to use the MaxMin algorithm to find the best answer.
     * Since finding the max and the min will give you the difference in an array.
     */
    public int Difference(int [] arr){
        int min,max;
        if(arr[0]<=arr[1]) {
            min = arr[0];
            max = arr[1];
        }
        else{
            min=arr[1];
            max=arr[0];
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i+1]>=arr[i]){
                if(arr[i+1]>max)
                    max=arr[i+1];
                if(arr[i]<min)
                    min=arr[i];
            }
            else { //arr[i]>arr[i+1]
                if(arr[i]>max)
                    max=arr[i];
                if(arr[i+1]<min)
                    min=arr[i+1];
            }
        }
        if (arr.length%2!=0) {
            if(arr[arr.length - 1] > max)
                max=arr[arr.length - 1];
            if(arr[arr.length - 1]<min)
                min=arr[arr.length - 1];
        }
        return max-min;
    }

}
