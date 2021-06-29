package com.ndxs.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;

/**
 * @description:
 * @author: waguju
 * @time: 2021.6.28 10:37
 */
@Slf4j
@Component
public class CodeConfig {
    
    private HashMap<String,String> codeTable;

    @PostConstruct
    public void init(){
        String filePath = "codeFile.txt";
        codeTable = new HashMap<>();

        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line;
            int index = 0;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                if (line.length() >0) {
                    String key = line.substring(0, line.indexOf(":"));
                    String value = line.substring(line.indexOf(":") + 1);
                    codeTable.put(key,value);
                    index++;
                }
            }
            log.info("{} initialize code count:{}", filePath, index);
        } catch (IOException e) {
            log.error("{}文件加载异常", filePath, e);
        }

    }
    
}
