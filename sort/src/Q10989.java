import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {

    public static void main(String[] args) throws IOException {

        int[] numArr = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            numArr[x] += 1;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numArr.length; i++){
            while(numArr[i] > 0){
                sb.append(i);
                sb.append('\n');
                numArr[i]--;
            }
        }
        System.out.println(sb.toString());


    }
}
