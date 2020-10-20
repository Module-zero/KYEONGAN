import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Q1309 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int sizeOfMatrix = Integer.parseInt(bf.readLine());
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for(int i = 0 ; i < sizeOfMatrix ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0 ; j < sizeOfMatrix ;j++){
                matrix[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int cnt = 2;
        for(int i = 0; i < sizeOfMatrix ; i ++){
            for(int j = 0 ; j < sizeOfMatrix ; j ++){
                cnt = dfs(matrix,i,j,sizeOfMatrix,cnt);
            }
        }
        int[] check = new int[(cnt-2)];
        for(int[] mat : matrix){
            for(int i : mat){
                if(i >= 2)check[i-2] ++;
            }
        }
        Arrays.sort(check);
        System.out.println(cnt-2);
        for(int num : check){
            System.out.print(num+" ");
        }
    }
    private static int dfs(int[][] matrix,int i,int j,int n,int cnt){
        if(i >= n || j >= n|| j< 0 || i < 0){
            return cnt;
        }
        if(matrix[i][j] == 1) {
            matrix[i][j] = cnt;
            dfs(matrix,i,j+1,n,cnt);
            dfs(matrix,i+1,j,n,cnt);
            dfs(matrix,i-1,j,n,cnt);
            dfs(matrix,i,j-1,n,cnt);
            return cnt+1;
        }
        return cnt;
    }
}
