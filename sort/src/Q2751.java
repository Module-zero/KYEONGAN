import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class Q2751 {
    static int[] numArr;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader (new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        numArr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(bf.readLine());
        }
        quickSort(numArr,0,n-1);
        StringBuilder sb = new StringBuilder();
        for(int i : numArr){
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void quickSort(int[] numArr,int start,int end){
        if(start < end) {
            int pivot = partition(start, end);
            quickSort(numArr, start, pivot - 1);
            quickSort(numArr, pivot + 1, end);
        }
    }
    public static int partition(int start, int end){
        int front = start;
        int pivot = (start + end) / 2;
        int pivotValue = numArr[pivot];
        swap(pivot,end);
        for (int i = start; i < end; i++) {
            if (numArr[i] < pivotValue) {
                int tmp = numArr[front];
                numArr[front] = numArr[i];
                numArr[i] = tmp;
                front ++;
            }
        }
        swap(front,end);
        return front;
    }
    public static void swap(int a, int b){
        int tmp = numArr[a];
        numArr[a] = numArr[b];
        numArr[b] = tmp;
    }
}
