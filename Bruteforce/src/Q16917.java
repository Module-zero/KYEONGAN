import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16917 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int z = Integer.parseInt(str[2]);

        int ansX = Integer.parseInt(str[3]);
        int ansY = Integer.parseInt(str[4]);

        int ans = 0;
        if(x+y > z*2){
            if(ansX > ansY){
                ans += (ansY * z * 2);
                ansX -= ansY;
                ansY = 0;
            }
            else{
                ans += (ansX * z * 2);
                ansY -= ansX;
                ansX = 0;
            }
        }
        else{
            ans = (ansX * x) + (ansY * y);
            ansX = 0;
            ansY = 0;
        }
        if(ansX != 0){
            if(x > 2*z){
                ans += (2*z*ansX);
            }
            else{
                ans += (x*ansX);
            }
        }
        if(ansY != 0){
            if(y > 2*z){
                ans += (z*2*ansY);
            }
            else{
                ans += (y*ansY);
            }
        }
        System.out.println(ans);
    }
}
