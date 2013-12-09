/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkit.keyword.sub.parse;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * RUN Luck Man
 * 使用dom4j解析xml文件
 * @author qiaokai
 * @date 2013-12-9 10:57:59
 */
public class JdomParseSRGS {

    final String filename = "keyword1.xml";

    /**
     * 加载xml
     */
    public void loadXML() {
    }

    /**
     * 读文件
     * @param fileName
     * @return
     * @throws MalformedURLException
     * @throws DocumentException 
     */
    public Document read(String fileName) throws MalformedURLException, DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(fileName));
        return document;
    }
    
    /**
     * 获取根节点元素
     * @param doc
     * @return 
     */
    public Element getRootElement(Document doc){
        return doc.getRootElement();
    }
    
    public String getCurrentPath(){
        return JdomParseSRGS.class.getResource("").getPath();
//        return Class.class.getClass().getResource("").getPath();
//         return new File("").getAbsolutePath();
//        URL resource = getClassLoader().getResource("myFile.xml");
//        return resource.getPath();
    }
    
    
    
    
    
    public static void main(String args[]) throws MalformedURLException {
        System.out.println("aaa");
        final String filename = "D:\\java\\workspace\\HuaWeiInterface\\target\\classes\\keyword1.xml";
        JdomParseSRGS dom4j = new JdomParseSRGS();
        try {
//            String path=dom4j.getCurrentPath()+filename;
//            System.out.println(path);
            Document document = dom4j.read(filename);
          //该步进行关键调用方法 遍历执行xml文档内容
            document.accept(new MyVisitor());
            System.out.println(document.getName());
            Element rootElement = dom4j.getRootElement(document);
            System.out.println("rootElement:"+rootElement.getName() );
        } catch (MalformedURLException ex) {
            Logger.getLogger(JdomParseSRGS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(JdomParseSRGS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
