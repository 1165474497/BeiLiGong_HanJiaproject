package org.vrlab.chemistrydatabase.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class MaterialDataUtils {
    public static Map<String,Object> getMaterialData(String cas){
        ClassPathResource resource = new ClassPathResource("materials/"+cas+".json");
        try {
            // 读取文件内容到字符串
            String content = new String(Files.readAllBytes(resource.getFile().toPath()));

            // 将 JSON 字符串转换为 Map 对象
            return JSON.parseObject(content, new TypeReference<>() {});
            // 输出 Map 对象以验证结果
        } catch (IOException ignored) {

        }
        return null;
    }
}
