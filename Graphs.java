package com.sirdave.data_structures;

import java.util.*;

public class Graphs {
    public static String[] bfsGetPath(HashMap<String, String[]> graph, String startNode, String endNode){

        if (!graph.containsKey(startNode)){
            throw new IllegalArgumentException("Start node not in graph");
        }

        if (!graph.containsKey(endNode)){
            throw new IllegalArgumentException("End node not in graph");
        }

        Queue<String> nodeToVisit = new ArrayDeque<>();
        nodeToVisit.add(startNode);

        HashMap<String, String> pathToNode = new HashMap<>();
        pathToNode.put(startNode, null);

        while (!nodeToVisit.isEmpty()){
            String currentNode = nodeToVisit.remove();

            if (currentNode.equals(endNode))
                return reconstructPath(pathToNode, startNode, endNode);

            for (String neighbour: graph.get(currentNode)){
                if (!pathToNode.containsKey(neighbour)){
                    nodeToVisit.add(neighbour);
                    pathToNode.put(neighbour, currentNode);
                }
            }
        }
        return null;
    }

    public static String[] reconstructPath(HashMap<String, String> path, String startNode, String endNode){

        List<String> shortestPath = new ArrayList<>();
        String current = endNode;

        while (current != null){
            shortestPath.add(current);
            current = path.get(current);
        }
        Collections.reverse(shortestPath); // get the correct order by reversing

        return shortestPath.toArray(new String[0]);
    }

    public static void main(String[] args) {
        HashMap<String, String[]> network = new HashMap<>() {{
            put("Min", new String[]{"William", "Jayden", "Omar"});
            put("William", new String[]{"Min", "Noam"});
            put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
            put("Ren", new String[]{"Jayden", "Omar"});
            put("Amelia", new String[]{"Jayden", "Adam", "Miguel"});
            put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
            put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
            put("Noam", new String[]{"Nathan", "Jayden", "William"});
            put("Omar", new String[]{"Ren", "Min", "Scott"});
        }};

        System.out.println(Arrays.toString(bfsGetPath(network, "Jayden", "Adam")));
    }
}
