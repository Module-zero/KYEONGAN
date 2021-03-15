import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Q1712 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] str = bf.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        if(b >= c){
            System.out.println(-1);
            return;
        }
        int gap = c-b;
        int start = c - gap;
        int answer = (a+b-start)/gap + 1;
        System.out.println(answer);
        return;

    }
}
