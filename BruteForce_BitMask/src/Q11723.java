import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11723 {
    static int[] array;
    public static void main (String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        array = new int[21];
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            String command = str[0];
            int num = Integer.parseInt(str[1]);
            switch(command){
                case "add":
                    break;
                case "check":
                    break;
                case "remove":
                    break;
                case "toggle":
                    break;
                case "all":
                    break;
                case "empty":
                    break;
                default:
                    break;
            }
        }
    }
    public static void add(int n ){

    }
}
