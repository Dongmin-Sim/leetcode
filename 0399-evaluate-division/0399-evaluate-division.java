import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String src = equation.get(0), dsc = equation.get(1);

            double value = values[i];

            graph.putIfAbsent(src, new HashMap<>());
            graph.putIfAbsent(dsc, new HashMap<>());
            graph.get(src).put(dsc, value);
            graph.get(dsc).put(src, 1.0 / value);
        }

        /// 쿼리 돌면서 dfs
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0), dsc = query.get(1);

            HashSet<String> visited = new HashSet<>();
            result[i] = dfs(src, dsc, graph, visited, 1.0);
        }
        return result;
    }

    private double dfs(String src, String dsc, Map<String, Map<String, Double>> graph,
        HashSet<String> visited, double acc) {
        if (!graph.containsKey(src) || !graph.containsKey(dsc)) return -1;
        if (src.equals(dsc)) return acc;

        visited.add(src);
        Map<String, Double> srcMap = graph.get(src);
        for (Entry<String, Double> entry : srcMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                double result = dfs(entry.getKey(), dsc, graph, visited, acc * entry.getValue());
                if (result != -1) return result;
            }
        }
        return -1;
    }
}