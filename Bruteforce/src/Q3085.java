import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q3085 {
    static int hon = 1;
    static int ver = -1;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        char[][] candy = new char[n][n];

        for(int i = 0 ; i < n; i ++){
            candy[i] = bf.readLine().toCharArray();
        }
        int max = 0;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                int honTmp = count(candy,i,j+1,n,candy[i][j],hon);
                int verTmp = count(candy,i+1,j,n,candy[i][j],ver);
                if(max < honTmp){
                    max = honTmp;
                }
                if(max < verTmp){
                    max = verTmp;
                }
            }
        }
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(swap(candy,i,j,i+1,j,n)){
                    for(int k = i; k <= i+1 ; k ++){
                        for(int z = 0 ; z < n ; z++){
                            int honTmp = count(candy,k,z,n,candy[k][z],hon);
                            if(honTmp > max){
                                max = honTmp;
                            }
                        }
                    }
                    for(int k = 0 ; k < n ; k ++){
                        int verTmp = count(candy,k,j,n,candy[k][j],ver);
                        if(max < verTmp){
                            max = verTmp;
                        }
                    }
                    swap(candy,i,j,i+1,j,n);
                }
                if(swap(candy,i,j,i,j+1,n)){
                    for(int k = j ; k <= j+1 ; k ++){
                        for(int z = 0 ; z < n ; z++){
                            int verTmp = count(candy,z,k,n,candy[z][k],ver);
                            if(max < verTmp){
                                max = verTmp;
                            }
                        }
                    }
                    for(int k = 0 ; k < n ; k++){
                        int honTmp = count(candy,i,k,n,candy[i][k],hon);
                        if(max < honTmp){
                            max = honTmp;
                        }
                    }
                    swap(candy,i,j,i,j+1,n);
                }
            }
        }
        System.out.println(max);
    }
    public static int count(char[][] candy,int i , int j , int n, char before, int comp){
        if(j == n || i == n){
            return 0;
        }
        if(comp == hon) {
            if (before == candy[i][j]) {
                return 1 + count(candy,i,j+1,n,before,hon);
            }
        }
        else{
            if (before == candy[i][j]) {
                return 1 + count(candy,i+1,j,n,before,ver);
            }
        }
        return 0;
    }
    public static boolean swap(char[][] candy, int i,int j, int ni,int nj,int n){
        if(i == n || j == n || ni >= n || nj >= n){
            return false;
        }
        char tmp = candy[i][j];
        candy[i][j] = candy[ni][nj];
        candy[ni][nj] = tmp;
        return true;
    }
}
