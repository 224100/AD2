import java.util.Scanner;

public class fractional_kanpsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        Node[] a =new Node[sc.nextInt()];
        double w =50;
        double p = 0;
        for(int i =0;i<a.length;i++){
            System.out.println("Enter the price and weight of item "+(i+1)+": ");
            a[i]=new Node(sc.nextDouble(),sc.nextDouble());
        }
        for(int i =0;i<a.length;i++){
            for(int j =0;j<a.length-i-1;j++){
                if(a[j].ratio<a[j+1].ratio){
                    Node temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        int i =0;
        for(;i<a.length;i++){
            if(w>=a[i].weight){
                p+=a[i].price;
                w-=a[i].weight;
            }
            else if(w!=0){
                p+=(w/a[i].weight)*a[i].price;
            }
        }
        System.out.println("final  : "+p);
        System.out.println("PS C:\\Aman_2241001030>");
    }
}
class Node{
    double price;
    double weight;
    double ratio;

    public Node(double price, double weight) {
        this.price = price;
        this.weight = weight;
        ratio=price/weight;
    }

}