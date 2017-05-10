package com.ctci.chapter4;

import java.util.*;

/**
 * Created by zambro on 5/9/17.
 */
public class ProjectDependency {

    public static Map<Character, Node> nodeMap = new HashMap<>();

    public static class Node {
        char data;
        Set<Node> incomingEdges;
        Set<Node> outGoingEdges;

        public Node(char data) {
            this.data = data;
            this.incomingEdges = new HashSet<>();
            this.outGoingEdges = new HashSet<>();
        }

    }

    public static char[] findBuildOrder(char[] projects, char[][] dependencies) {
        char[] build = new char[projects.length];
        Set<Character> set = new HashSet<>();
        nodeMap = new HashMap<>();

        for (char[] dependency : dependencies) {
            char child = dependency[0];
            char parent = dependency[1];
            Node childNode = nodeMap.get(child);
            Node parentNode = nodeMap.get(parent);
            if (childNode == null) {
                childNode = new Node(child);
                nodeMap.put(child, childNode);
            }

            if (parentNode == null) {
                parentNode = new Node(parent);
                nodeMap.put(parent, parentNode);
            }

            parentNode.outGoingEdges.add(childNode);
            childNode.incomingEdges.add(parentNode);
        }


        for (char project : projects) {
            set.add(project);
            if(!nodeMap.containsKey(project)) {
                nodeMap.put(project, new Node(project));
            }
        }


        int start = 0;
        Map.Entry<Character, Node> entry = null;
        while ((entry = getNodeWithoutIncomingEdge()) != null) {
            //There exists a node without any incoming edge
            build[start] = entry.getKey();
            start++;

            //Find all nodes where incoming edge is 'node' and remove those;
            removeIncomingConnection(entry.getValue());
        }

        return build;
    }

    private static void removeIncomingConnection(Node incomingNode) {
        if (nodeMap != null)
            //Go through the map and remove the node
            for (Map.Entry<Character, Node> entry : nodeMap.entrySet()) {
                Node node = entry.getValue();
                node.incomingEdges.remove(incomingNode);
            }

        nodeMap.remove(incomingNode.data);
    }

    private static Map.Entry<Character, Node> getNodeWithoutIncomingEdge() {
        if (nodeMap != null)
            for (Map.Entry<Character, Node> entry : nodeMap.entrySet()) {
                Node node = entry.getValue();
                if (node.incomingEdges.isEmpty())
                    return entry;
            }
        return null;
    }

    public static void main(String[] args) {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = {
                {'d', 'a'},
                {'b', 'f'},
                {'d', 'b'},
                {'a', 'f'},
                {'c', 'd'}
        };

        char[] build = findBuildOrder(projects, dependencies);
        System.out.println(Arrays.toString(build));

        dependencies = new char[][]{
                {'d', 'a'},
                {'b', 'f'},
                {'d', 'b'},
                {'a', 'f'},
                {'c', 'd'},
                {'f', 'b'}
        };

        build = findBuildOrder(projects, dependencies);
        System.out.println(Arrays.toString(build));

        dependencies = new char[][]{
                {'e', 'a'},
                {'e', 'b'},
                {'g', 'd'},
                {'a', 'c'},
                {'a', 'f'},
                {'a', 'b'},
                {'c', 'f'},
                {'b', 'f'}
        };

        projects = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        build = findBuildOrder(projects, dependencies);
        System.out.println(Arrays.toString(build));
    }
}
