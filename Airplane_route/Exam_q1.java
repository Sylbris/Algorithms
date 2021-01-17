public class Exam_q1 {
    public class Node{
        int x_val=0;
        int y_val=0;
        int price=0;
        int num_of_paths=0;
        String [] path;

        public Node(int price){
            this.price=price;
        }
    }


    /**
     * Input : A Matrix containing prices for each edge, 2 points .
     * Output : A price for the shorest path possible between those 2 points.
     * @param mat
     * @param p1q1
     * @param p2q2
     * @return
     */
    public int air_plane(Node [][]mat, int [] p1q1,int []p2q2){
        int x1=p1q1[0];
        int y1=p1q1[1];
        int x2=p2q2[0];
        int y2=p2q2[0];

        if(x1>=x2 && y1<y2)
            return -1;
        if(x1<x2 && y1>y2)
            return -1;
        ///////////////////////////Return the lesser point/////////////////////////
        // wlog (x1,y1) <= (x2,y2)
        mat[x1][y1].price=0;
        for(int i=x1+1;i<=x2;i++){
            mat[i][y1].price=mat[i-1][y1].price+mat[i-1][y1].y_val;
        }
        for(int j=y1+1;j<=y2;j++){
            mat[x1][j].price=mat[x1][j-1].price+mat[x1][j-1].x_val;
        }

        for(int i=1;i<x2;i++){
            for(int j=1;j<y2;j++){
                int a=mat[i-1][j].price+mat[i-1][j].y_val;
                int b=mat[i][j-1].price+mat[i][j-1].x_val;
                if(a<b)
                    mat[i][j].price=a;
                if(a>b)
                    mat[i][j].price=b;
                if(a==b)
                    mat[i][j].price=a;
            }
        }
        return mat[x2][y2].price;
    }

    /**
     * Code to return price of lowest path or num_of_paths for each node.
     * @return
     */
    public int get_all_paths(Node [][] mat){
        int n=mat.length; //rows
        int m=mat[0].length; //cols

        mat[0][0].price=0;

        for(int i=1;i<n;i++){
            mat[i][0].price=mat[i-1][0].price+ mat[i-1][0].y_val;
            mat[i][0].num_of_paths=1;
        }
        for(int j=1;j<m;j++){
            mat[0][j].price=mat[0][j-1].price+ mat[0][j-1].x_val;
            mat[0][j].num_of_paths=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int a=mat[i-1][j].price+mat[i-1][j].y_val;
                int b=mat[i][j-1].price+mat[i][j-1].x_val;
                if(a<b){
                    mat[i][j].price=a;
                    mat[i][j].num_of_paths=mat[i-1][j].num_of_paths;
                }
                if(a>b){
                    mat[i][j].price=b;
                    mat[i][j].num_of_paths=mat[i][j-1].num_of_paths;
                }
                if(a==b){
                    mat[i][j].price=a;
                    mat[i][j].num_of_paths=mat[i-1][j].num_of_paths+mat[i][j-1].num_of_paths;
                }
            }
        }
        return mat[n-1][m-1].price;

    }


    public static void main(String []args){



    }
}
