package Prim;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimWithPriorityQueue {

    int graph[][];
    boolean visited[];
    int size;
    PriorityQueue<Node> priorityQueue;

    public PrimWithPriorityQueue(int[][] graph, int size) {
        this.graph = graph;
        this.size = size;
        this.visited = new boolean[size];
        this.priorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    }

    public int getMinimumCost() {

        visited[0] = true;  // 임의의 정점 0번 노드 선택

        for (int i = 0; i < this.size; i++) {
            if (graph[0][i] > 0) {  // 0번 노드의 인접 노드를 우선순위 큐에 삽입
                priorityQueue.add(new Node(i, graph[0][i]));
            }
        }
        int sumCost = 0;

        while (priorityQueue.isEmpty() == false) {
            Node node = priorityQueue.remove();
            if (visited[node.vertex]) continue;
            visited[node.vertex] = true;
            sumCost += node.weight;

            for (int i = 0; i < size; i++) {
                if (graph[node.vertex][i] > 0) {    // 새로 연결된 노드의 인접 노드를 우선순위 큐에 삽입
                    priorityQueue.add(new Node(i, graph[node.vertex][i]));
                }
            }
        }

        return sumCost;
    }
}

class Node {

    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
