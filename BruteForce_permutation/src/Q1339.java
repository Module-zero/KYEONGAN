import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int n = Integer.parseInt(bf.readLine());
        String[] strArr = new String[n];
        char[] check = new char[10];
        int[] weight = new int[10];
        for(int i = 0 ; i < n ; i ++){
            strArr[i] = bf.readLine();
            int ten = 1;
            for(int j = strArr[i].length()-1 ; j >= 0; j--){
                for(int k = 0 ; k < 10; k ++){
                    if(check[k] == 0){
                        check[k] = strArr[i].charAt(j);
                        weight[k] += ten;
                        break;
                    }
                    if(check[k] == strArr[i].charAt(j)){
                        weight[k] += ten;
                        break;
                    }
                }
                ten *= 10;
            }
        }
        Arrays.sort(weight);
        int sum = 0;
        for(int i = 9; i >= 0 ; i--){
            sum += (weight[i]*i);
        }
        System.out.println(sum);
    }
}
