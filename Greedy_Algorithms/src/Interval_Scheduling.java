public class Interval_Scheduling {
    public static void main(String[] args) {
        node[] n = new node[5];
        n[0]= new node('a',1,3);
        n[1]= new node('b',2,5);
        n[2]= new node('c',3,9);
        n[3]= new node('d',6,8);
        n[4]= new node('e',9,10);
        for(int i =0;i<n.length;i++){
            for(int j =0 ; j < n.length-i-1;j++){
                if(n[j].et>n[j+1].et)
                {
                    node temp = n[j];
                    n[j]=n[j+1];
                    n[j+1]=temp;
                }
            }
        }
        System.out.println("Intervals are:");
        node temp = new node('1',0,0);
        for(int i =0;i<n.length;i++){
            if(temp.et<=n[i].st){
                System.out.println(n[i]);
                temp=n[i];
            }
        }

    }
}
class node{
    char a;
    int st;
    int et;
    node(char a , int st,int et){
        this.a =a;
        this.st=st;
        this.et=et;
    }
    @Override
    public String toString(){
        return a+" "+st+" "+et;
    }

        }
