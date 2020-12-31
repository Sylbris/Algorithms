import javax.swing.*;

import java.util.Arrays;

import static java.lang.Math.min;

public class Edit_levinstein {

    public static int Edit_distance(String s, String t){
        int m=s.length(); //kitten
        int n=t.length(); //sitting
        int [][] d=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            d[i][0]=i;
        }
        for(int j=1;j<n+1;j++){
            d[0][j]=j;
        }
        for(int j=1;j<n+1;j++){
            for(int i=1;i<m+1;i++){
                if(s.charAt(i-1)==t.charAt(j-1)) {
                    d[i][ j]=min(d[i - 1][j]+1, min(d[i][ j - 1]+1, d[i - 1][ j - 1]));
                }
                else
                    d[i][ j]=min(d[i - 1][j]+1, min(d[i][ j - 1]+1, d[i - 1][ j - 1]+1));
            }
        }
        //System.out.println(Arrays.deepToString(d).replace("], ", "]\n"));
        return d[m][n];
    }
    public static void main(String [] args){
        String s="kitten";
        String t="sitting";
        System.out.println("Distance is: "  + Edit_distance(t,s));
    }
}
