package DisjointSet;

public class DisjointSetTest {

    public static void main(String[] args) {

        DisjointSet disjointSet = new DisjointSet(6);

        disjointSet.unionSet(2, 3);
        disjointSet.unionSet(4, 5);
        disjointSet.unionSet(3, 5);

        for (int i = 0; i < 6; i++) {
            System.out.println(i + "노드의 집합: " + disjointSet.findSet(i) + " 집합 원소 개수: " + disjointSet.getSetSize(i));
        }
    }
}
