import java.util.*;

public class ShortestPath {

    // Find vertex with minimum distance
    int minDistance(int dist[], boolean sptSet[], int V) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // Print the path using parent[]
    void printPath(int[] parent, int j) {
        if (parent[j] == -1) {
            System.out.print(j);
            return;
        }

        printPath(parent, parent[j]);
        System.out.print(" -> " + j);
    }

    // Dijkstra’s Algorithm with path reconstruction
    void dijkstra(int[][] graph, int src, int dest, int V) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        int[] parent = new int[V]; // To store the shortest path tree

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parent[i] = -1; // Initialize parent of each node
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            if (u == -1) break; // No more reachable vertices

            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Output result
        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + src + " to " + dest);
        } else {
            System.out.println("\nShortest distance from " + src + " to " + dest + " is: " + dist[dest]);
            System.out.print("Path: ");
            printPath(parent, dest);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of vertices
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter the adjacency matrix (0 for no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Take source and destination vertex
        System.out.print("Enter the source vertex (0 to " + (V - 1) + "): ");
        int src = sc.nextInt();

        System.out.print("Enter the destination vertex (0 to " + (V - 1) + "): ");
        int dest = sc.nextInt();

        // Run Dijkstra
        ShortestPath sp = new ShortestPath();
        sp.dijkstra(graph, src, dest, V);

        sc.close();
    }
}
