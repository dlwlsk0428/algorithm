import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9655_돌게임 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(bf.readLine());
        System.out.println(n%2==0 ? "CY" : "SK");

	}
}
