import java.util.*;

public class TreeTraversal {
    public List<String> traverse(String root, Map<String, List<String>> tree) {
        List<String> visited = new ArrayList<>();
        if (root == null || !tree.containsKey(root)) return visited;

        Queue<String> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<String> levelNodes = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                String node = queue.poll();

                // Flip order based on current direction
                if (leftToRight) {
                    levelNodes.addLast(node);
                } else {
                    levelNodes.addFirst(node);
                }

                // Add children (always in given order: left then right)
                List<String> children = tree.getOrDefault(node, new ArrayList<>());
                for (String child : children) {
                    queue.offer(child);
                }
            }

            visited.addAll(levelNodes);
            leftToRight = !leftToRight; // Alternate direction
        }

        return visited;
    }

    // Test method
    public static void main(String[] args) {
        TreeTraversal tt = new TreeTraversal();

        // Test Tree 1
        Map<String, List<String>> tree1 = new HashMap<>();
        tree1.put("a", Arrays.asList("b", "c"));
        tree1.put("b", new ArrayList<>());
        tree1.put("c", Arrays.asList("d", "e"));
        tree1.put("d", new ArrayList<>());
        tree1.put("e", new ArrayList<>());

        System.out.println(tt.traverse("a", tree1)); // ["a", "b", "c", "e", "d"]

        // Test Tree 2
        Map<String, List<String>> tree2 = new HashMap<>();
        tree2.put("A", Arrays.asList("B", "C"));
        tree2.put("B", Arrays.asList("D", "E"));
        tree2.put("C", Arrays.asList("F", "G"));
        tree2.put("D", new ArrayList<>());
        tree2.put("E", new ArrayList<>());
        tree2.put("F", new ArrayList<>());
        tree2.put("G", new ArrayList<>());

        System.out.println(tt.traverse("A", tree2)); // ["A", "B", "C", "G", "F", "E", "D"]
    }
}

