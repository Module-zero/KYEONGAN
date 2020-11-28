import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2022 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        double x = Double.parseDouble(size[0]);
        double y = Double.parseDouble(size[1]);
        double z = Double.parseDouble(size[2]);

        double left = 0;
        double right = Math.min(x,y);
        double answer = 0 ;
        for(int i = 0 ; i < 10000 ; i ++){
            double mid = (left + right)/2;
            double h1 = Math.sqrt(x*x - mid*mid);
            double h2 = Math.sqrt(y*y - mid*mid);
            double h = (h1*h2)/(h1+h2);
            if(h > z){
                left = mid;
                answer = mid;
            }
            else{
                right = mid;

            }
        }
        System.out.printf("%.3f",answer);
    }
}
