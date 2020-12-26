import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11004 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int numbers[] = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());

        }
        quick_sort(numbers,0,n);
        for(int num : numbers){
            System.out.print(num+" ");
        }
        System.out.println(numbers[k-1]);
    }

    public static void quick_sort(int[] arr, int start, int end){
        if(start >= end){
            return ;
        }
        int pivotIdx = start;
        long pivot = arr[pivotIdx];
        int i = start;
        int j = end;
        while(true){
            while(++i < end && arr[i] < pivot );
            while(--j > start && arr[j] > pivot );
            if(i >= j){
                int tmp = arr[pivotIdx];
                arr[pivotIdx] = arr[j];
                arr[j] = tmp;
                pivotIdx = j;
                break;
            }
            else{
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quick_sort(arr,start,pivotIdx);
        quick_sort(arr,pivotIdx+1,end);
    }
}
