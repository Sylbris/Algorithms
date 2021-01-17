import java.util.Arrays;

public class Exam_q7 {
    /**
     * Find LCS
     */
    public static String LCS(char []A,char []B){
        int n=A.length;
        int m=B.length;
        int [][]mat=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            mat[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            mat[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(A[i-1]==B[j-1]) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                }
                else{
                    mat[i][j]=Math.max(mat[i-1][j],mat[i][j-1]);
                }
            }

        }
        //System.out.println(Arrays.deepToString(mat));
        //Building the answer.
        int i=n;
        int j=m;
        String ans="";
        while(mat[i][j]!=0){
            if(A[i-1]==B[j-1]){
                ans=A[i-1]+ans;
                i--;j--;
            }
            else {
                if(mat[i][j-1]>mat[i-1][j]){
                    j--;
                }
                else i--;
            }
        }
        return ans;
    }

    /**
     * LCS using 3 strings.
     * @param A
     * @param B
     * @param C
     * @return
     */
    public static String LCS_3(int []A,int []B, int []C){
        int n=A.length;
        int m=B.length;
        int k=C.length;
        int [][][]mat=new int[n+1][m+1][k+1];
        //RESET ALL MATRIX
        for(int i=0;i<n+1;i++){
            mat[i][0][0]=0;
        }
        for(int i=0;i<m+1;i++){
            mat[0][i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            mat[0][0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++) {
                for (int r=1; r < k + 1; r++) {
                    if (A[i - 1] == B[j - 1]&& A[i-1]==C[r-1]) {
                        mat[i][j][r] = 1 + mat[i - 1][j - 1][r-1];
                    } else {
                        mat[i][j][r] = Math.max(mat[i][j][r-1],Math.max(mat[i - 1][j][r], mat[i][j - 1][r]));
                    }
                }
            }

        }
        int i=n;
        int j=m;
        int p=k;
        String ans="";
        while(mat[i][j][p]!=0){
            if(A[i-1]==B[j-1] && A[i-1]==C[p-1]){
                ans=A[i-1]+ans;
                i--;j--;p--;
            }
            else {
                if(mat[i][j-1][p]>mat[i-1][j][p] && mat[i][j-1][p]>mat[i][j][p-1]){
                    j--;
                }
                else {
                    if(mat[i-1][j][p]>mat[i][j-1][p] && mat[i-1][j][p]>mat[i][j][p-1])
                        i--;
                    else
                        p--;
                }
                }
            }
        return ans;

    }
    public static void main(String[]args){
        char [] A={'a','b','c','b','d','a','b'};
        char [] B={'b','d','c','a','b','a'};
        System.out.println(LCS(A,B));

        int []C={1,2,3,4,5};
        int []D={4,5,1,2,3};
        int []E={4,5,6,7,8};
        System.out.println(LCS_3(C,D,E));
    }
}
