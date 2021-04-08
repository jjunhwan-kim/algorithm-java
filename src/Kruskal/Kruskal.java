package Kruskal;

import DisjointSet.DisjointSet;

import java.util.Collections;
import java.util.List;

public class Kruskal {

    int size;
    List<Edge> edges;
    DisjointSet disjointSet;

    public Kruskal(int size, List<Edge> edges) {
        this.size = size;
        this.edges = edges;
        this.disjointSet = new DisjointSet(size);
    }

    public int getMinimumCost() {

        Collections.sort(edges, ((o1, o2) -> o1.weight - o2.weight));

        int sumCost = 0;
        int selectCount = 0;

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            if (disjointSet.findSet(u) == disjointSet.findSet(v)) {
                continue;
            }

            disjointSet.unionSet(u, v);
            sumCost += edge.weight;
            selectCount++;
            if (selectCount >= size - 1) {
                break;
            }
        }
        return sumCost;
    }
}

class Edge {
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.weight = cost;
    }
}