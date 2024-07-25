import java.util.*;

public class Leetcode133 {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.get(current).neighbors.add(new Node(neighbor.val));
                    map.put(neighbor, map.get(current).neighbors.get(map.get(current).neighbors.size() - 1));
                    queue.add(neighbor);
                } else {
                    map.get(current).neighbors.add(map.get(neighbor));
                }

            }
        }

        return map.get(node);

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Leetcode133 leetcode133 = new Leetcode133();
        Node clonedNode = leetcode133.cloneGraph(node1);

        System.out.println(clonedNode.val);
    
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
