import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11967 {
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int M = Integer.parseInt(init[1]);
        for(int i = 0 ; i < M ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int a = Integer.parseInt(tmp[2]);
            int b = Integer.parseInt(tmp[3]);
        }

    }
}
