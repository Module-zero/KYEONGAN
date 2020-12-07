import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11650 {
    static int[][] idxAry;
    static int[][] tmp;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        idxAry = new int[n][2];
        tmp = new int[n][2];
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            idxAry[i][0] = Integer.parseInt(str[0]);
            idxAry[i][1] = Integer.parseInt(str[1]);
        }

        sort(0,n-1);
        for(int[] i : idxAry){
            System.out.println(i[0]+" "+i[1]);
        }
    }
    public static void sort(int start,int end){
        if(start == end){
            return;
        }
        int mid = (start+end)/2 ;
        sort(start,mid);
        sort(mid+1,end);
        merge(start,end);
    }
    public static void merge(int start,int end){
        int mid = (start+end)/2;
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= end){
            if(idxAry[i][0] > idxAry[j][0]){
                tmp[k][0] = idxAry[j][0];
                tmp[k++][1] = idxAry[j++][1];
            }
            else if(idxAry[i][0] < idxAry[j][0]){
                tmp[k][0] = idxAry[i][0];
                tmp[k++][1] = idxAry[i++][1];
            }
            else{
                if(idxAry[i][1] < idxAry[j][1]){
                    tmp[k][0] = idxAry[i][0];
                    tmp[k++][1] = idxAry[i++][1];
                }
                else{
                    tmp[k][0] = idxAry[j][0];
                    tmp[k++][1] = idxAry[j++][1];
                }
            }
        }
        while(j <= end){
            tmp[k][0] = idxAry[j][0];
            tmp[k++][1] = idxAry[j++][1];
        }
        while(i <= mid){
            tmp[k][0] = idxAry[i][0];
            tmp[k++][1] = idxAry[i++][1];
        }
        for(int ii = start; ii <= end; ii ++){
            idxAry[ii][0] = tmp[ii-start][0];
            idxAry[ii][1] = tmp[ii-start][1];
        }
    }
}
