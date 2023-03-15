package com.markus.algorithm.graph.company;

/**
 * @author: markus
 * @date: 2023/3/15 9:53 PM
 * @Description: 图节点
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Node {
    private String id;
    private String label;

    public Node() {
    }

    public Node(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
