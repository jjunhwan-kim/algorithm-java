package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalTest {

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,32));
        edges.add(new Edge(0,2,31));
        edges.add(new Edge(0,5,60));
        edges.add(new Edge(0,6,51));
        edges.add(new Edge(1,2,21));
        edges.add(new Edge(2,4,46));
        edges.add(new Edge(2,6,25));
        edges.add(new Edge(3,4,34));
        edges.add(new Edge(3,5,18));
        edges.add(new Edge(4,5,40));
        edges.add(new Edge(4,6,51));

        Kruskal kruskal = new Kruskal(7, edges);

        System.out.println(kruskal.getMinimumCost());
    }
}
