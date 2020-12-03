import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class Q2751 {
    static int[] numArr;
    static int[] tmpArr;
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader (new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        numArr = new int[n];
        tmpArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(bf.readLine());
        }
        sort(0,n-1);
        StringBuilder sb = new StringBuilder();
        for(int i : numArr){
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void sort(int start,int end){
        if(start == end){
            return;
        }
        int mid = (start+end)/2;
        sort(start,mid);
        sort(mid+1,end);
        merge(start,end);
    }
    public static void merge(int start, int end){
        int mid = (start+end)/2;
        int i = start;
        int j = mid+1;
        int k = 0 ;

        while(i <= mid && j <= end){
            if(numArr[i] < numArr[j]){
                tmpArr[k++] = numArr[i++];
            }
            else{
                tmpArr[k++] = numArr[j++];
            }
        }
        while (i <= mid){
            tmpArr[k++] = numArr[i++];
        }
        while (j <= end){
            tmpArr[k++] = numArr[j++];
        }
        for(int ii = start ; ii <= end; ii ++){
            numArr[ii] = tmpArr[ii-start];
        }
    }
}
