package Prim;

public class PrimWithArray {

    int parent[];
    int weight[];

    int graph[][];
    int size;

    public PrimWithArray(int[][] graph, int size) {
        this.graph = graph;
        this.size = size;
        this.parent = new int[size];
        this.weight = new int[size];
    }

    public int getMinimumCost() {

        for (int i = 0; i < size; i++) {
            weight[i] = -1; // -1로 초기화, 아직 선택되지 않은 정점으로 초기화
        }

        weight[0] = 0;  // 임의의 정점 0번 노드 선택

        for (int k = 1; k < size; k++) {   // n - 1개의 노드 선택
            int minWeight = Integer.MAX_VALUE;
            int minVertex = 0;
            int minParent = 0;

            for (int i = 0; i < size; i++) {
                if (weight[i] < 0) continue;    // 아직 MST에 포함되지 않은 노드

                for (int j = 0; j < size; j++) {
                    if (weight[j] >= 0) continue;   // 새로 선택될 노드는 음수이어야 함, 양수는 이미 선택된 노드, 양수인 노드 선택시 사이클 발생함

                    if (graph[i][j] > 0 && graph[i][j] < minWeight) {
                        minVertex = j;
                        minParent = i;
                        minWeight = graph[i][j];
                    }
                }
            }

            parent[minVertex] = minParent;
            weight[minVertex] = minWeight;
        }
        int sumCost = 0;
        for (int i = 0; i < size; i++) {
            sumCost += weight[i];
        }
        return sumCost;
    }
}
