import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N + 2];

        for(int i = 1; i < N; i++) {
            String[] nodes = br.readLine().split(" ");

            int nodeA = Integer.parseInt(nodes[0]);
            int nodeB = Integer.parseInt(nodes[1]);

            if(tree[nodeA - 1] == null) {
                tree[nodeA - 1] = new Node(nodeA - 1);
            }

            if(tree[nodeB - 1] == null) {
                tree[nodeB - 1] = new Node(nodeB - 1);
            }

            tree[nodeA - 1].addNode(tree[nodeB - 1]);
            tree[nodeB - 1].addNode(tree[nodeA - 1]);
        }

        tree[0].setParents(null);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < tree.length - 2; i++) {
            sb.append((tree[i].parents.value + 1) + "\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static class Node {
        int value;
        Node parents;
        List<Node> connected;

        public Node(int N) {
            this.value = N;
        }

        public void addNode(Node node) {
            if(this.connected == null) {
                this.connected = new ArrayList<>();
            }
            this.connected.add(node);
        }

        public void findChild() {
            for(int i = 0; i < this.connected.size(); i++) {
                if(this.connected.get(i) != this.parents) {
                    Node child = this.connected.get(i);
                    child.setParents(this);
                }
            }
        }

        public void setParents(Node node) {
            this.parents = node;
            findChild();
        }
    }
}
