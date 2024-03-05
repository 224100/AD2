import java.util.*;
public class Main
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner (System.in);
        System.out.print("enter no.of vertices:");
        int v=sc.nextInt();
        graph g=new graph(v);
        System.out.print("enter no.of edges:");
        int e=sc.nextInt();
        System.out.println("enter adjacent vertices:");
        for(int i=0;i<e;i++)
        {
            System.out.print("=>");
            int x=sc.nextInt();
            int y=sc.nextInt();
            g.insert_edge(x, y);
        }
        System.out.print("enter the source vertex for traversal:");
        int s=sc.nextInt();
        System.out.println("DFS traversal:  ");
        g.dfs(s);
        System.out.println();
        System.out.println("BFS traversal:  ");
        g.bfs(s);

    }

}