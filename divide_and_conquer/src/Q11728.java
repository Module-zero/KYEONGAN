import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11728 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int[] aArr = new int[aSize];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < aSize; i ++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int[] bArr = new int[bSize];
        for(int i = 0 ; i < bSize ; i ++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        merge(aArr,bArr,aSize,bSize);
    }
    public static void merge(int[] aArr,int[] bArr, int aSize, int bSize){
        int aStart = 0;
        int bStart = 0;
        StringBuilder sb = new StringBuilder();
        while(aStart < aSize && bStart < bSize){
            if(aArr[aStart] < bArr[bStart]){
                sb.append(aArr[aStart++]+" ");
            }
            else{
                sb.append(bArr[bStart++]+" ");
            }
        }
        while(aStart < aSize){
            sb.append(aArr[aStart++]+" ");
        }
        while(bStart < bSize){
            sb.append(bArr[bStart++]+" ");
        }
        System.out.println(sb.toString());
    }
}
