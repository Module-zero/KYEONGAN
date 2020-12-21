import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1891 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader ( new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        long d = Long.parseLong(str[0]);
        long num = Long.parseLong(str[1]);

        str = bf.readLine().split(" ");
        long x = Long.parseLong(str[0]);
        long y = Long.parseLong(str[1]);

    }
}
