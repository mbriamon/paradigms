import java.util.*;

public class Main {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a", Arrays.asList("b", "e"));
        graph.put("b", Arrays.asList("c", "d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("b"));
        graph.put("e", Arrays.asList("a", "f"));
        graph.put("f", new ArrayList<>());

        List<String> result = dfs.traverse("a", graph);
        System.out.println(result);  // Output: [a, b, c, e, f, d]
    }
}

