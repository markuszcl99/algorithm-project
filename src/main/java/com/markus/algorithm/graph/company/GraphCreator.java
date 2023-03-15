package com.markus.algorithm.graph.company;

import com.alibaba.fastjson.JSONObject;
import com.markus.algorithm.graph.company.domain.GraphJsonEntity;
import com.markus.algorithm.graph.company.domain.GraphJsonMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: markus
 * @date: 2023/3/15 9:58 PM
 * @Description: 图创建
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GraphCreator {
    private static final String PATH_NAME = "/Users/zhangchenglong/IdeaProjects/algorithm-project/src/main/java/com/markus/algorithm/graph/company/file/graph.json";

    public static void main(String[] args) {
        JSONObject jsonObject = GraphJsonMapping.getJsonFile(PATH_NAME);
        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (Object value : jsonObject.values()) {
            JSONObject object = (JSONObject) value;
            String name = object.getObject("name", String.class);
            String op = object.getObject("op", String.class);
            String category = object.getObject("category", String.class);
            List<String> inputs = object.getObject("inputs", List.class);
            String desc = object.getObject("desc", String.class);
            Object attrs = object.get("attrs");
            GraphJsonEntity entity = new GraphJsonEntity(name, op, category, inputs, desc, attrs);

            Node node = new Node();
            node.setId(entity.getName());
            node.setLabel(entity.getName());
            nodes.add(node);

            // 根据inputs参数 确定边
            if (entity.getInputs().size() == 0) {
                continue;
            }
            Set<String> sources = new HashSet<>();
            for (String input : entity.getInputs()) {
                String source = input.split(":")[0];
                if (!sources.contains(source)) {
                    Edge edge = new Edge(source, name, "", 1);
                    sources.add(source);
                    edges.add(edge);
                }

            }


        }
//        System.out.println(nodes);
//        System.out.println(edges);
        Graph graph = new Graph(nodes, edges);
        System.out.println(JSONObject.toJSONString(graph));
    }


}
