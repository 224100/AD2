import java.util.Scanner;

public class brute_force {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the String : ");
        String s =sc.nextLine();
        System.out.println("Enter the patter : ");
        String t =sc.nextLine();
        int n =s.length();
        int m =t.length();
        for(int i =0;i<n-m+1;i++){
            int flag =0;
            for(int j =0;j<m;j++){
                if(s.charAt(i+j)==t.charAt(j)){
                    flag=1;
                }
                else {
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                System.out.println("present at : "+i);
            }
        }
        //System.out.println("PS C:\\Aman_2241001030> ");
    }
}