import java.io.*;

public class Q2609 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int a = A;
        int b = B;
        while(b != 0){
            int r = a % b ;
            a = b;
            b = r;
        }
        int lcm = A*B/a;
        System.out.print(a+" "+lcm);
    }
}
