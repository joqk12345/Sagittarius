package com.thikit.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 关于文件操作的工具类 util for File
 *
 * @author Administrator
 */
public class FileUtil {

    /**
     * 将关键词集合 写入到txt文本当中去
     *
     * @param keywords
     * @param fileName
     */
    public static void writeSet(Set<String> keywords, String fileName) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            for (String keyword : keywords) {
                bw.write(keyword);
                bw.newLine();
            }
        } catch (IOException e) {
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    public static void write(File file, String data) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static List<String> readList(File file) {
        BufferedReader br = null;
        List<String> data = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(file));
            for (String str = null; (str = br.readLine()) != null;) {
                data.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
