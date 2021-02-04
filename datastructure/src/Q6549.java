import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6549 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int[] dp = new int[n];
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < n ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
                if( arr[i] < min){
                    min = arr[i];
                }
            }
            

        }

    }
}
