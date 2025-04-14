import java.util.*;

public class DFS {
    public List<String> traverse(String root, Map<String, List<String>> graph) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfsHelper(root, graph, visited, result);
        return result;
    }

    private void dfsHelper(String node, Map<String, List<String>> graph, Set<String> visited, List<String> result) {
        if (visited.contains(node)) return;
        visited.add(node);
        result.add(node);
        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(neighbor, graph, visited, result);
        }
    }
}
