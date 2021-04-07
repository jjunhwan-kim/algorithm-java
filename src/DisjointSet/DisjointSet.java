package DisjointSet;

public class DisjointSet {

    private int[] parent;

    public DisjointSet(int size) {
        this.parent = new int[size];

        for (int i = 0; i < size; i++) {
            this.parent[i] = -1;
        }
    }

    public void makeSet(int v) {
        this.parent[v] = -1;
    }

    public int findSet(int v) {
        if (this.parent[v] < 0) {
            return v;
        }
        return findSet(this.parent[v]);
    }

    int getSetSize(int v) {
        return -parent[findSet(v)];
    }

    public void unionSet(int u, int v) {
        int r1 = findSet(u);
        int r2 = findSet(v);
        if (r1 == r2) return;

        parent[r1] += parent[r2];
        parent[r2] = r1;
    }
}
