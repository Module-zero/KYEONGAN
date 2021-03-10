public class KakaoRecruitment2021_4 {
    int[][] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int INF = 100000*201;
        list = new int[n+1][n+1];
        for(int i = 1 ; i < n+1; i ++){
            for(int j = 1 ; j < n+1; j ++){
                list[i][j] = INF;
                if(i == j){
                    list[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i < fares.length; i ++){
            int[] target = fares[i];
            int c = target[0];
            int d = target[1];
            int f = target[2];
            list[c][d] = f;
            list[d][c] = f;
        }
        for(int k = 1 ; k < n+1 ; k ++){
            for(int i = 1 ; i < n+1 ; i ++){
                for(int j = 1 ; j < n+1 ; j ++){
                    if(list[i][k] < INF && list[k][j] < INF){
                        int tmp = list[i][k] + list[k][j];
                        if(list[i][j] > tmp){
                            list[i][j] = tmp;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < n+1 ; i ++){
            int t = list[s][i]+list[i][a]+list[i][b];
            if( min > t){
                min = t;
            }
        }
        answer = min;
        return answer;
    }
}
