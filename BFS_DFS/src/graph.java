import java.util.*;
public class graph
{
    private LinkedList <Integer> adjacencyList[];
    public graph(int v)
    {
        adjacencyList=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adjacencyList[i]=new LinkedList<Integer>();
        }
    }
    public void insert_edge(int x,int y)
    {
        adjacencyList[x].add(y);
        adjacencyList[y].add(x);
    }
    void dfs(int s)
    {
        boolean flag[]=new boolean[adjacencyList.length];
        Stack<Integer> stack=new Stack<Integer>();
        stack.add(s);
        flag[s]=true;
        while(!stack.empty())
        {
            int adj=stack.pop();
            System.out.print(adj+"  ");
            for(int i:adjacencyList[adj])
            {
                if(flag[i]==false)
                {
                    flag[i]=true;
                    stack.add(i);
                }
            }
        }

    }
    void bfs(int s)
    {
        boolean flag[]=new boolean[adjacencyList.length];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        flag[s]=true;
        while(!q.isEmpty())
        {
            int adj=q.remove();
            System.out.print(adj+"  ");
            for(int i:adjacencyList[adj])
            {
                if(flag[i]==false)
                {
                    flag[i]=true;
                    q.add(i);
                }
            }
        }

    }

}