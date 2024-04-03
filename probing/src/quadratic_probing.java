
import java.util.*;
public class quadratic_probing
{
    private int c_size;
    private final int t_size;private final int[] hashtable;
    quadratic_probing(int x)
    {
        c_size=0;t_size=x; hashtable=new int[x];
        Arrays.fill(hashtable,Integer.MIN_VALUE);
    }
    boolean isFull()
    {
        return c_size==t_size;
    }
    boolean isEmpty()
    {
        return c_size==0;
    }
    void insert(int x)
    {
        if(isFull())

            System.out.println("Cannot add: hashtable is full");

        else
        {
            int i=x%t_size;
            if(i<0)
                i=i*-1;
            if(hashtable[i]==Integer.MIN_VALUE)

                hashtable[i]=x;

            else
            {
                int res=collisionHandler(i);
                if(res==-2)
                {
                    System.out.println("Cannot find a place to insert!");
                    return;
                }
                else
                    hashtable[res]=x;
            }
            c_size++;
        }
    }
    void display()
    {
        if(isEmpty())
            System.out.println("Hash table is empty!");
        else
        {
            System.out.println("Hash table contains :");
            for(int i=0;i<hashtable.length;i++)

                if(hashtable[i]==Integer.MIN_VALUE)
                    System.out.print("null ");
                else
                    System.out.print(hashtable[i]+" ");

            System.out.println();
        }
    }
    int collisionHandler(int value)
    {
        int i=1;int val=value;
        while(hashtable[value]!=Integer.MIN_VALUE)
        {
            value=(val+(int)Math.pow(i,2))%t_size; i++;
            if(i>=t_size)
                return -2;
        }

        return value;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter size of the hash table:");
        int x=sc.nextInt();
        quadratic_probing qp=new quadratic_probing(x);
        qp.display();
        qp.insert(6);	qp.display();
        qp.insert(7);	qp.display();
        qp.insert(11);	qp.display();
        qp.insert(20);	qp.display();
        qp.insert(25);	qp.display();
        qp.insert(30);	qp.display();
    }
}



//OUTPUT:-
//Enter size of the hash table:5
//Hash table is empty!
//Hash table contains :
//null 6 null null null
//Hash table contains :
//null 6 7 null null
//Hash table contains :
//11 6 7 null null
//Hash table contains :
//11 6 7 null 20
//Cannot find a place to insert!
//Hash table contains :
//11 6 7 null 20
//Cannot find a place to insert!
//Hash table contains :
//11 6 7 null 20