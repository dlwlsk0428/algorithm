import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1015_수열정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A[][] = new int[n][2];

        for(int i = 0; i<n; i++) {
            A[i][0] = Integer.parseInt(st.nextToken());
            for(int j = 0; j<i; j++) {
                if(A[i][0] < A[j][0]) A[j][1]++;
                else if (A[i][0] >= A[j][0]) A[i][1]++;
            }
        }

        for(int i = 0; i<n; i++) {
            System.out.print(A[i][1] + " ");
        }
    }
}
