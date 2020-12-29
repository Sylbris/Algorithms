import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class airplane_problem {
    public class Node{
        int x, y, price, numOfPaths;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
            this.price = 0;
            this.numOfPaths = 0;

        }

    } //

    public static int cheapestPrice=0;
    public static int numOfPaths=0;

    /**
     * We build our matrix
     * our end point will contain the shortest path distance.
     * @param mat
     */
    public static void buildPriceMatrix(Node [][] mat){
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0; //update the first price to be 0.
        for (int i=0; i<n; i++) { // first column
            mat[i][0].price = mat[i - 1][0].y + mat[i - 1][0].price;
            mat[i][0].numOfPaths = 1;
        }
        for (int j=0; j<m; j++) { // first row
            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
            mat[0][j].numOfPaths = 1;
        }
        //We choose the minimum of sum , and update.
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;
                if (a < b) {
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i - 1][j].numOfPaths;
                } else if (a > b) {
                    mat[i][j].price = b;
                    mat[i][j].numOfPaths = mat[i ][j-1].numOfPaths;
                } else //x==y
                     {
                    mat[i][j].price = a;
                    mat[i][j].numOfPaths = mat[i][j-1].numOfPaths+mat[i-1][j].numOfPaths;
            }
            }
        }
                cheapestPrice = mat[n-1][m-1].price;
                numOfPaths=mat[n-1][m-1].numOfPaths;

            }

    /**
     *
     */
    public final static int n=20;
    public static Node [][] mat=new Node[n][n];
    public static void build_all_paths(LinkedList<Integer> path, int i, int j, List <List<Integer>> path_table) {
        int a = 0, b = 0;
        if (i == 0 && j == 0)
            path_table.add(path);
        else if (i == 0 && j > 0) {
            path.addFirst(0);
            build_all_paths(path, i, j - 1, path_table);
        }
        else if (j == 0 && i > 0) {
            path.addFirst(1);
            build_all_paths(path, i - 1, j, path_table);
        }
        else {
            a = mat[i - 1][j].price + mat[i - 1][j].y;
            b = mat[i][j - 1].price + mat[i][j - 1].x;
        }
        if (a < b) {
            path.addFirst(1);
            build_all_paths(path, i - 1, j, path_table);
        }
        else if (a > b) {
            path.addFirst(0);
            build_all_paths(path, i, j - 1, path_table);
        }
        else {//a==b{}
            path.addFirst(1);
            build_all_paths(path, i - 1, j, path_table);
            path.removeFirst();
            path.addFirst(0);
            build_all_paths(path, i, j - 1, path_table);
        }
    }


    /**
     * Find shortest path in list
     * @param mat
     * @return
     */
        public static List<Integer> getOneCheapestPath(Node [][] mat){
            buildPriceMatrix(mat);
            LinkedList<Integer> shortestPath=new LinkedList<>();
            int i = mat.length-1, j = mat[0].length-1;//we start from the end point.
            while(i>0 && j>0) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;
                if (a <= b) {
                    shortestPath.addFirst(1);
                    i--;
                } else {
                    shortestPath.addFirst(0);
                    j--;
                }
            }

        return shortestPath;
}
    public static void main(String [] args){
            Node [][] mat=new Node[3][4];

    }

    }
