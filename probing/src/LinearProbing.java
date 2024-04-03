import java.util.*;
public class LinearProbing
{
    private int c_size;
    private final int t_size;private final int[] hashtable;
    LinearProbing(int x)
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
        {
            System.out.println("Cannot add: hashtable is full");
        }
        else
        {
            int i=x%t_size;
            if(i<0)
            {
                i=i*-1;
            }
            if(hashtable[i]==Integer.MIN_VALUE)
            {
                hashtable[i]=x;
            }
            else
            {
                hashtable[collisionHandler(i)]=x;
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
            {
                if(hashtable[i]==Integer.MIN_VALUE)
                    System.out.print("null  ");
                else
                    System.out.print(hashtable[i]+" ");
            }
            System.out.println();
        }
    }
    int collisionHandler(int value)
    {
        int i=1;int val=value;
        while(hashtable[value]!=Integer.MIN_VALUE)
        {
            value=(val+i)%t_size; i++;
        }
        return value;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter size of the hash table:");
        int x=sc.nextInt();
        LinearProbing lp=new LinearProbing(x);
        lp.display();
        lp.insert(6);
        lp.display();
        lp.insert(-7);
        lp.display();
        lp.insert(11);
        lp.display();
        lp.insert(20);
        lp.display();
        lp.insert(25);
        lp.display();
        lp.insert(30);
        lp.display();
    }
}


//OUTPUT:-
//Enter size of the hash table:5
//Hash table is empty!
//Hash table contains :
//null  6 null  null  null
//Hash table contains :
//null  6 -7 null  null
//Hash table contains :
//null  6 -7 11 null
//Hash table contains :
//20 6 -7 11 null
//Hash table contains :
//20 6 -7 11 25
//Cannot add: hashtable is full
//Hash table contains :
//20 6 -7 11 25