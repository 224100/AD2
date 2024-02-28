import java.util.*;
public class dfs_t {
    private final int V;

    private final LinkedList<Integer>[] adj;

    dfs_t(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w)
    {

        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited)
    {

        visited[v] = true;
        System.out.print(v + "-->");
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    void DFS(int v)
    {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of vertices :");
        dfs_t g = new dfs_t(sc.nextInt());


        int a=0;
        do{
            System.out.println("Enter the vertices connected : ");
            g.addEdge(sc.nextInt(),sc.nextInt());
            System.out.println("to exit enter -1 else 0");
            a=sc.nextInt();
        }while(a!=-1);
        System.out.println("Enter the node to start dfs : ");
        g.DFS(sc.nextInt());
    }
}
