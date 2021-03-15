import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q17103 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        boolean[] arr = prime();
        for(int i = 0 ; i < t ; i ++){
            int num = Integer.parseInt(bf.readLine());
            int cnt = 0;
            for(int j = 1 ; j <= num/2 ; j++){
                if(!arr[j]&&!arr[num-j]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static boolean[] prime(){
        boolean[] arr = new boolean[1000001];
        arr[1] = true;
        for(int i = 2 ; i < 1000000 ; i ++){
            if(arr[i] == false){
                for(int j = i+i ; j<1000000 ; j+=i){
                    arr[j] = true;
                }
            }
        }
        return arr;
    }
}
