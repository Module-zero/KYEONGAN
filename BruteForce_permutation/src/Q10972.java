import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q10972 {
    static int n ;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        String[] strArr = bf.readLine().split(" ");
        Integer[] numArr = new Integer[n];
        for(int i = 0; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        int target = -1;
        boolean minFlag = false;
        for(int i = 0 ; i < n-1; i ++){
            if(numArr[i] < numArr[i+1]){
                if(minFlag) {
                    target = i-1;
                    minFlag = false;
                }
            }
            else{
                minFlag = true;
                target = i;
            }
        }
        if(target != -1){
            int minMax = target + 1;
            for(int i = target+1;i<n;i++){
                if(numArr[target] > numArr[i] && target+1 < n){
                    minMax = numArr[i] > numArr[minMax] ? i : minMax;
                }
            }
            if(minMax != -1){
                int tmp = numArr[target];
                numArr[target] = numArr[minMax];
                numArr[minMax] = tmp;
            }
            Arrays.sort(numArr,target+1,n, Collections.reverseOrder());
            for(int num : numArr){
                System.out.print(num+" ");
            }
            return;
        }
        else{
            System.out.println(target);
        }
    }

}
