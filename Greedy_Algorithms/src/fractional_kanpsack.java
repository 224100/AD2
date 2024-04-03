public class fractional_kanpsack {
    public static void main(String[] args) {
        Node[] a =new Node[3];
        double w =50;
        double p = 0;
        a[0]=new Node(60,10);
        a[1]=new Node(100,20);
        a[2]=new Node(120,30);
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