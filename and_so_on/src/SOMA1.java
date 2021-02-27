import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SOMA1 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int a = n/2;
        int r = n%2;
        StringBuilder sb = new StringBuilder();
        if(r == 1){
            a -= 1;
            sb.append(7);
        }
        for(int i = a ; i > 0 ; i --){
            sb.append(1);
        }
        System.out.println(sb);
    }
}
