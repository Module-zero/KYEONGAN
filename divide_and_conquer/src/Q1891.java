import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1891 {
    static char[] arr;
    static long x;
    static long y;
    static long ansI;
    static long ansJ;
    static StringBuilder answer;
    static long n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader ( new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        n = (long)Math.pow(2,Integer.parseInt(str[0]));
        arr = str[1].toCharArray();
        answer = new StringBuilder();
        str = bf.readLine().split(" ");
        x = Long.parseLong(str[0]);
        y = Long.parseLong(str[1])*(-1);
        go(0,0,n,0);
        find(0,0,n);
        System.out.println(answer);
    }
    public static void go(long i, long j,long d, int cnt){
        if(cnt >= arr.length || d == 1){
            ansI = i + y;
            ansJ = j + x;
            return;
        }
        switch(arr[cnt]){
            case '1':
                go(i,j+d/2,d/2,cnt+1);
                break;
            case '2':
                go(i,j,d/2,cnt+1);
                break;
            case '3':
                go(i+d/2,j,d/2,cnt+1);
                break;
            default :
                go(i+d/2,j+d/2,d/2,cnt+1);
                break;
        }
    }
    public static void find(long i, long j, long d){
        if(d <= 1){
            return;
        }
        if(i <= ansI && ansI < i+d/2 && j+d/2 <= ansJ && ansJ < n){
            answer.append("1");
            find(i,j+d/2,d/2);
        }
        else if(i <= ansI && ansI < i+d/2 && j <= ansJ && ansJ < j+d/2){
            answer.append("2");
            find(i,j,d/2);
        }
        else if(i+d/2 <= ansI && ansI < n && j <= ansJ && ansJ < j+d/2){
            answer.append("3");
            find(i+d/2,j,d/2);
        }
        else if(i+d/2 <= ansI && ansI < n && j+d/2 <= ansJ && ansJ < n){
            answer.append("4");
            find(i+d/2,j+d/2,d/2);
        }
        else{
            answer = new StringBuilder();
            answer.append("-1");
            return;
        }
    }
}