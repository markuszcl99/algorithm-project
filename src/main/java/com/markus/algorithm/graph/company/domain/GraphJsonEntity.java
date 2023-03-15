package com.markus.algorithm.graph.company.domain;

import java.util.List;

/**
 * @author: markus
 * @date: 2023/3/15 10:02 PM
 * @Description: 图-文件实体
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GraphJsonEntity {
    private String name;
    private String op;
    private String category;
    private List<String> inputs;
    private String desc;
    private Object attr;

    public GraphJsonEntity() {
    }

    public GraphJsonEntity(String name, String op, String category, List<String> inputs, String desc, Object attr) {
        this.name = name;
        this.op = op;
        this.category = category;
        this.inputs = inputs;
        this.desc = desc;
        this.attr = attr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getAttr() {
        return attr;
    }

    public void setAttr(Object attr) {
        this.attr = attr;
    }
}
