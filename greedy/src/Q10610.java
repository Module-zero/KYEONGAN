import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10610 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader (new FileReader(new File("data.txt")));

        char[] charArr = bf.readLine().toCharArray();
        int size = charArr.length;
        int[] numArr = new int [size];
        long sum = 0;
        boolean zero = false;
        for(int i = 0 ; i < size; i ++){
            int num = charArr[i] - '0';
            numArr[i] = num;
            if(num == 0){
                zero = true;
            }
            else{
                sum += num;
            }
        }
        if(!zero || sum % 3 != 0){
            System.out.println(-1);
            return;
        }
        Arrays.sort(numArr);
        StringBuilder sb = new StringBuilder();
        for(int i = size-1; i >=0 ; i --){
            sb.append(numArr[i]);
        }
        System.out.println(sb.toString());
    }

}
