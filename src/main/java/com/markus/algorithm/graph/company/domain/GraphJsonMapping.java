package com.markus.algorithm.graph.company.domain;

import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.Nullable;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: markus
 * @date: 2023/3/15 10:04 PM
 * @Description: 图-文件映射
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GraphJsonMapping {
    @Nullable
    public static JSONObject getJsonFile(String path) {
        try {
            FileReader reader = new FileReader(path);
            return JSONObject.parseObject(IOUtils.toString(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
