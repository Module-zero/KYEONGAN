import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1929 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        boolean[] arr = prime();
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        StringBuilder sb = new StringBuilder();
        for(int i = m ; i <= n; i++){
            if(arr[i] == false){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean[] prime(){
        boolean[] arr = new boolean[1000001];
        arr[1] = true;
        for(int i = 2 ; i <= 1000000 ; i ++){
            if(arr[i] == false){
                for(int j = i*2 ; j <= 1000000 ; j += i){
                    arr[j] = true;
                }
            }
        }
        return arr;
    }
}
