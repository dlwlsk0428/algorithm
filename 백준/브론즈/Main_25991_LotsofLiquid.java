package 백준.브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25991_LotsofLiquid {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        double cubes[] = new double[n];
        double total = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<n; i++) {
            cubes[i] = Double.parseDouble(st.nextToken());
            total += Math.pow(cubes[i], 3);
        }

        System.out.println(Math.cbrt(total));

    }
}
