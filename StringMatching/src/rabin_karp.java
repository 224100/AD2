import java.util.Scanner;

public class rabin_karp {
    static void search(String T, String P, int q,int d)
    {
        int m = T.length();
        int n = P.length();
        int p = 0;
        int t = 0;
        int h = (int)Math.pow(d,m-1)%q;
        for (int i = 0; i < m; i++) {
            p = (d * p + T.charAt(i)) % q;
            t = (d * t + P.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            int j;
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (P.charAt(i + j) != T.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }
            if (i < n - m) {
                t = (d * (t - P.charAt(i) * h) + P.charAt(i + m)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the text: ");
        String P = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String T = sc.next();
        search(T, P, 11,10);
    }
}
