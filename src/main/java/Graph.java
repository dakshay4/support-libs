import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dakshay on 15/10/2021.
 */
public class Graph {
    public static void graphTraversal(int[][] graph) {
        int size = graph.length;
//        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        List<Integer> terminatingNodes = new ArrayList<>();
        for(int i=0;i<size;i++) {
            if(graph[i].length==0) terminatingNodes.add(i);
        }
        for(int i=0;i<size;i++) {
            for(int j=0;j<graph[i].length;j++){

            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        graphTraversal(graph);
    }
}
