package com.ctci.library;

import java.util.*;

/**
 * Created by zambro on 4/23/17.
 */
public class Graph {

    private int id = 0;
    protected Map<Integer, Node> nodeList = new HashMap<>();

    protected static class Node {
        public int id;
        public int data;
        public List<Node> adjacents;

        public Node(int id, int data) {
            this.id = id;
            this.data = data;
            this.adjacents = new ArrayList<>();
        }
    }

    public Node getNode(int id) {
        return nodeList.get(id);
    }

    public int addNode(int data) {
        Node node = new Node(id++,data);
        nodeList.put(node.id, node);
        return node.id;
    }

    public void addEdge(int sourceId, int destId) {
        Node sourceNode = nodeList.get(sourceId);
        Node destNode = nodeList.get(destId);

        sourceNode.adjacents.add(destNode);
    }

    public void printBFS(int sourceId){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        queue.add(sourceId);
        while(!queue.isEmpty()) {
            int nodeId = queue.poll();
            if(visited.contains(nodeId))
                continue;
            visited.add(nodeId);
            Node sourceNode = nodeList.get(nodeId);
            System.out.print(sourceNode.data+" ");
            for(Node adjacent:sourceNode.adjacents)
                queue.add(adjacent.id);
        }
    }

    public void printDFS(int sourcId) {
        List<Integer> visited = new ArrayList<>();
        printDFS(nodeList.get(sourcId), visited);
    }

    //Pre-order
    private void printDFS(Node source, List<Integer> visited) {
        if(visited.contains(source.id))
            return;
        visited.add(source.id);
        System.out.print(source.data+" ");
        for(Node adjacent:source.adjacents)
            printDFS(adjacent, visited);
    }


    public static void main(String[] args) {
        Graph g = new Graph();
        g = Graph.createCTCTGraph1(g);


        System.out.print("BFS from node 0: ");
        g.printBFS(0);

        System.out.print("\nDFS from node 0: ");
        g.printDFS(0);
    }

    public static Graph createCTCTGraph1(Graph g) {
        System.out.println("Created node with id: "+g.addNode(0));
        System.out.println("Created node with id: "+g.addNode(1));
        System.out.println("Created node with id: "+g.addNode(2));
        System.out.println("Created node with id: "+g.addNode(3));
        System.out.println("Created node with id: "+g.addNode(4));
        System.out.println("Created node with id: "+g.addNode(5));
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(0,5);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.addEdge(3,2);
        g.addEdge(2,1);

        return g;
    }

}
