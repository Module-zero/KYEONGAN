import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;

public class Q1016 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bf.readLine().split(" ");
        long min = Long.parseLong(size[0]);
        long max = Long.parseLong(size[1]);
        long answer = max - min + 1;
        boolean[] check = new boolean[(int)((max-min)+1)];

        for(long i = 2; i*i <= max ; i ++){
            long start = i*i;
            for(long j = min/start ; start*j <= max ; j++){
                int index = (int)(start*j - min);
                if(start*j < min || check[index])continue;
                check[index] = true;
                answer--;
            }
        }

        out.println(answer);
    }

}

