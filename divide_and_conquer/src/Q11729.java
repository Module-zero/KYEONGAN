import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0 ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        move(n,1,3);
        System.out.println(cnt);
        System.out.print(sb.toString());
    }
    public static void move(int n, int x, int y){
        if(n == 0 )return;
        move(n-1,x,6-x-y);
        sb.append(x+" "+y+"\n");
        cnt ++;
        move(n-1,6-x-y,y);
    }
}
