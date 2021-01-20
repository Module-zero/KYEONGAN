import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16945 {
    static int[][] A ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        A = new int[3][3];

        for(int i = 0 ; i < 3 ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < 3 ; j ++){
                A[i][j] = Integer.parseInt(str[j]);
            }
        }
        
    }
}
