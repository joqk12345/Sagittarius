/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkit.keyword.sub.parse;

import com.thikit.util.FileUtil;
import java.util.HashSet;
import java.util.Set;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;

/**
 * 观察者模式实现对xml文档的高效访问 RUN Luck Man
 *
 * @author qiaokai
 * @date 2013-12-9 13:59:47
 */
public class MyVisitor extends VisitorSupport {
    /**
     * 读出的关键词列表
     */
    Set<String>  keywords = new HashSet<String>();

    @Override
    public void visit(Attribute node) {
//        super.visit(node); 
        if(node.isReadOnly()){
        //可以修改的
            System.out.println("Attribute : " + node.getName() + " = " + node.getValue());    
        }
    }

    @Override
    public void visit(Element node) {
//        super.visit(node); 
        if (node.isTextOnly()) {
            if(!node.getText().isEmpty()){
        //这里得到所有关键词列表  并将管将此列表吸入一个文件中去
                System.out.println("Element:" + node.getName() + "=" + node.getText());
                keywords.add(node.getTextTrim());
            }
            FileUtil.writeSet(keywords, "D://keywords.txt");
        }
    }
}
