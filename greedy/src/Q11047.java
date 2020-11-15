import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q11047 {
    static int[] numArr ;
    static int k;
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        k = Integer.parseInt(strArr[1]);
        numArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(bf.readLine());
        }
        int select = 0  ;
        boolean bigger = false;
        for(int i = 0 ; i < n ; i ++){
            select = i;
            if(numArr[i] > k){
                bigger = true;
                break;
            }
        }
        if(bigger){
            select-=1;
        }
        int answer = 0;
        do{
            answer += k/numArr[select];
            k = k % numArr[select];
            select--;
        }while(select >= 0);
        System.out.println(answer);
    }

}
