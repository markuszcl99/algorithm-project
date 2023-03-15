package com.markus.algorithm.graph.company;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/3/15 9:53 PM
 * @Description: 图结构
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Graph {
    List<Node> nodes;
    List<Edge> edges;

    public Graph() {
    }

    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
