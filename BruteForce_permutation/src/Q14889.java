import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Q14889 {
    static int[][] team;
    static int[] first;
    static int[] second;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        team = new int[n][n];
        for(int i = 0; i < n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                team[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        int[] permu = new int[n];
        for(int i = 0 ; i < n/2; i ++){
            permu[i] = -1;
        }
        int minValue = Integer.MAX_VALUE;
        do{
            int fSum = 0;
            int sSum = 0;
            first = new int[n/2];
            second = new int[n/2];
            int firstCnt = 0;
            int secondCnt = 0;
            for(int i = 0 ; i < n ; i ++){
                if(permu[i] == 0){
                    first[firstCnt++] = i;
                }
                else{
                    second[secondCnt++] = i;
                }
            }
            for(int i = 0 ; i < n/2 ; i ++){
                for(int j = 0; j < n/2; j ++){
                    if(i == j )continue;
                    fSum += team[first[i]][first[j]];
                    sSum += team[second[i]][second[j]];
                }
            }
            minValue = Math.min(minValue,Math.abs(fSum - sSum));
        }while(minValue != 0 && nextPermut(permu));
        System.out.println(minValue);
    }
    public static boolean nextPermut(int[] permu){
        for(int start = 0 ; start < permu.length-1; start++){
            if(permu[start] < permu[start+1]){
                int tmp = permu[start];
                permu[start] = permu[start+1];
                permu[start+1] = tmp;
                Arrays.sort(permu,0,start+1);
                return true;
            }
        }
        return false;
    }

}
