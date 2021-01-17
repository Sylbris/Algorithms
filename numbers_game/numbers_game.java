public class numbers_game {
    public static int[][] matrix(int [] game){
        int [][] mat=new int[game.length][game.length];
        //fill diagonal
        for(int i=0;i<mat.length;i++){
            mat[i][i]=game[i];
        }
        for(int i=game.length-2;i>0;i--){
            for(int j=i+1;j<game.length-1;j++){
                mat[i][j]=Math.max(game[i]-mat[i+1][j],game[j]-mat[i][j-1]);
            }
        }
        return mat;
    }
    public static void game_strategy(int [] game){
        int sum_of_first=0;
        int sum_of_second=0;
        int i=0;
        int j=game.length-1;
        int first=0;
        int second=0;
        int [][]mat=matrix(game);
        for(int k=0;k< game.length/2;k++){
            if(game[i]-mat[i+1][j]>game[j]-mat[i][j-1]){
                sum_of_first+=game[i];
                first=i++;
            }
            else {
                sum_of_first+=game[j];
                first=j--;
            }
            if(i!=j){
                if(game[i]-mat[i+1][j]>game[j]-mat[i][j-1]){
                    sum_of_second+=game[i];
                    second=i++;
                }
                else {
                    sum_of_second+=game[j];
                    second=j--;
                }
            }
            else {
                second=j;
                sum_of_second+=game[j];
            }
            System.out.println("first: game["+first+"]=" +game[first]+ " Second: " + second + "= "+ game[second] );
        }
        System.out.println("first sum "+ sum_of_first + " second sum is " + sum_of_second);
    }
    public static void main(String[]args){
        int []game={5,20,10,1};
        game_strategy(game);
    }
}
