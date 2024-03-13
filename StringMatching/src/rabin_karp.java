import java.util.Scanner;

public class rabin_karp {
    static void search(String P, String T, int q,int d)
    {
        int n = T.length();
        int m = P.length();

        if(n>m){
            int p = 0;
            int t = 0;
            int flag=0;
            int h = (int)Math.pow(d,m-1)%q;
            for (int i = 0; i < m; i++) {
                p = (d * p + P.charAt(i)) % q;
                t = (d * t + T.charAt(i)) % q;
            }
            for (int i = 0; i <= n - m; i++) {
                int j;
                if (p == t) {
                    for (j = 0; j < m; j++) {
                        if (T.charAt(i + j) != P.charAt(j))
                            break;
                    }
                    if (j == m) {
                        System.out.println("Pattern found at index " + i);
                        flag=1;
                    }
                }
                if (i < n - m) {
                    t = (d * (t - T.charAt(i) * h) + T.charAt(i + m)) % q;
                    if (t < 0)
                        t = (t + q);
                }
            }
            if(flag==0){
                System.out.println("Pattern not found!!");
            }
        }
        else System.out.println("invalid input!!");
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the text: ");
        String T = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String P = sc.next();
        search(P, T, 11,10);
    }
}
