import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q14225 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        String[] strArr = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        boolean[] answer = new boolean[2000000];
        for(int i = 1 ; i < (1 << n) ;i ++){
            int sum = 0;
            for(int j = 0 ; j < n ; j ++){
                if( (i&(1<<j)) != 0){
                    sum += arr[j];
                }
            }
            answer[sum] = true;
        }
        for(int i = 1 ; i <= (1 << n) ; i ++){
            if(answer[i])continue;
            System.out.println(i);
            break;
        }
        return;
    }
}
