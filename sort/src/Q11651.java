import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11651 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        long[] yx = new long[n];
        int size = 1000000;
        int tmp = 100000;

        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            long x = Integer.parseInt(str[0]) + tmp;
            long y = Integer.parseInt(str[1]) + tmp;
            yx[i] = (y*size) + x;
        }
        Arrays.sort(yx);
        StringBuilder sb = new StringBuilder();
        for(long i : yx){
            long x = i%size - tmp;
            long y = i/size - tmp;
            sb.append(x).append(" ").append(y).append("\n");
        }
        System.out.print(sb);

    }

}
