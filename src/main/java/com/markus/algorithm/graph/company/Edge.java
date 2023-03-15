package com.markus.algorithm.graph.company;

/**
 * @author: markus
 * @date: 2023/3/15 9:53 PM
 * @Description: 图的边
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Edge {
    private String source;
    private String target;
    private String label;
    private Integer weight;

    public Edge() {
    }

    public Edge(String source, String target, String label, Integer weight) {
        this.source = source;
        this.target = target;
        this.label = label;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
