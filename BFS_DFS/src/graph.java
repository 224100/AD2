import java.util.*;
public class graph
{
    private LinkedList <Integer> adj[];
    public graph(int v)
    {
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<Integer>();
        }
    }
    public void insert_edge(int x,int y)
    {
        adj[x].add(y);
        adj[y].add(x);
    }
    void dfs(int s)
    {
        boolean flag[]=new boolean[adj.length];
        Stack<Integer> stack=new Stack<Integer>();
        stack.add(s);
        flag[s]=true;
        while(!stack.empty())
        {
            int a=stack.pop();
            System.out.print(a+"  ");
            for(int i:adj[a])
            {
                if(!flag[i])
                {
                    flag[i]=true;
                    stack.add(i);
                }
            }
        }

    }
    void bfs(int s)
    {
        boolean flag[]=new boolean[adj.length];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        flag[s]=true;
        while(!q.isEmpty())
        {
            int a=q.remove();
            System.out.print(a+"  ");
            for(int i:adj[a])
            {
                if(!flag[i])
                {
                    flag[i]=true;
                    q.add(i);
                }
            }
        }

    }

}