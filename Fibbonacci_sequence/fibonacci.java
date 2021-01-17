public class fibonacci {
    /**
     * Calculate the n'th fibonnaci number using matrix multiplication.
     * @param n
     * @return
     */

    public int matrix_fibb(int n){
        int [][]ans={{1,1},{1,0}}; //Will be our fibbonaci matrix.
        int [][]A={{1,1},{1,0}};
        n=n-2;
        while(n!=0){
            if(n%2==1)
                ans=mulMat(ans,A);
            A=mulMat(A,A);
            n=n/2;


        }
        return ans[0][0];
    }
	public static int[][] mulMat(int[][] m1, int[][] m2) {
		int[][] ans = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ans[i][j] = m1[i][0]*m2[0][j] + m1[i][1]*m2[1][j];
			}
		}
		return ans;
	}


    /**
     * Simple Divide and Conquer matrix multiplication algorithm, O(n^3)
     * @param arr1
     * @param arr2
     * @return
     */
    /*
    public int[][] MatrixMult(int A[][],int rowA,int colA,int B[][], int rowB,int colB){
        if(A.length==2){
            int C11=A[0][0]*B[0][0]+A[1][2]*B[1][0];
            int C12=A[0][0]*B[0][1]+A[0][1]*B[1][1];
            int C21=A[1][0]*B[0][0]+A[1][1]*B[1][0];
            int C22=A[1][0]*B[0][1]+A[1][1]*B[1][1];
            int [][] C={{C11,C12},{C21,C22}};
            return C;
        }
        else {
            int [][] C11=addMatrix(MatrixMult(A[][],B[][]),MatrixMult(A[1][2],B[2][1]);
            int [][] C12=addMatrix(MatrixMult(A[1][1],B[1][1]),MatrixMult(A[1][2],B[2][1]);
            int [][] C21=addMatrix(MatrixMult(A[1][1],B[1][1]),MatrixMult(A[1][2],B[2][1]);
            int [][] C22=addMatrix(MatrixMult(A[1][1],B[1][1]),MatrixMult(A[1][2],B[2][1]);



        }
    }
    */
}
