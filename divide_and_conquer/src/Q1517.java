import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1517 {
    static int[] arr;
    static int[] tmp;
    static long ans;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        tmp = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sort(0,n-1);
        System.out.println(ans);
    }
    public static void sort(int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        sort(start,mid);
        sort(mid+1,end);
        merge(start,end);
    }
    public static void merge(int start, int end){
        int mid = (start+end)/2;
        int l = start;
        int r = mid + 1;
        int k = 0 ;
        while(l <= mid && r <= end){
            if(arr[l] > arr[r]){
                tmp[k++] = arr[r++];
                ans += (mid-l+1);
            }
            else{
                tmp[k++] = arr[l++];
            }
        }
        while(l <= mid){
            tmp[k++] = arr[l++];
        }
        while( r <= end){
            tmp[k++] = arr[r++];
        }
        for(int i = start ; i <= end; i ++){
            arr[i] = tmp[i-start];
        }
    }
}
