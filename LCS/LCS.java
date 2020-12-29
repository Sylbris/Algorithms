import java.util.Arrays;

import static java.lang.Integer.max;

public class LCS {
    public static int[][] matrix(String x, String y){
        int m=x.length();
        int n=y.length();
        int [][]arr=new int[m+1][n+1];
        for(int i=0;i<m;i++){ // put 0s in first column.
            arr[i][0]=0;
        }
        for(int i=0;i<n;i++){ // put 0s in first row.
            arr[0][i]=0;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                    arr[i][j]=arr[i-1][j-1]+1;
                else
                    arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
            }
        }
        return arr;
    }
    public static void main(String []args){
        String a="abcbdab";
        String b="bdcaba";
        int [][] matrix=matrix(a,b);
        System.out.println(matrix[a.length()][b.length()]);
    }
}
