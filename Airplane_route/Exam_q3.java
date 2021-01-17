public class Exam_q3 {
    /**
     * Given an array of numbers. You may choose a number from start or end.
     */
    public int[][] buildMatrix(int []arr){
        //Create a 2D array in the size of arr.
        int n=arr.length;
        int [][]mat=new int [arr.length][arr.length];
        //Put in the diagnoal the numbers of the original array.
        for(int i=0;i<mat.length;i++){
            mat[i][i]=arr[i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n-1;j--){
                mat[i][j]=Math.max(arr[i]-mat[i+1][j],arr[j]-mat[i][j]);
            }
        }
        //mat[0][n-1] contains the max diff
        return mat;
    }
    public int get_max_diff(int [][]mat){
        return mat[0][mat.length-1];
    }

    /**
     * A function to print the moves of the game.
     * We keep a sum for each player.
     *
     * @param arr
     */
    public void get_game_moves(int []arr){
        int n=arr.length;
        int i=0;
        int j=n-1;

        int firstSum=0;
        int SecondSum=0;
        int first=0;
        int second=0;
        int [][] mat=buildMatrix(arr);

        //We go from end.
        for(int k=0;k<n/2;k++){
            //first takes a number.
            if(arr[i]-mat[i+1][j]>arr[j]-mat[i][j-1]){
                firstSum+=arr[i];
                first=i++;
            }
            //arr[i]-mat[i+1][j]<arr[j]-mat[i][j-1]
            else {
                firstSum+=arr[j];
                first=j--;
            }
            //second makes his move
            if(i!=j) {
                if (arr[i] - mat[i + 1][j] > arr[j] - mat[i][j - 1]) {
                    SecondSum += arr[i];
                    second = i++;
                } else {
                    SecondSum += arr[j];
                    second = j--;
                }
            }
            else{
                second=j;
                SecondSum+=arr[j];
            }
            System.out.println("first: game["+first+"] = "+arr[first]+
                    ", second: game["+second+"] = "+arr[second]);

        }

    }
}
