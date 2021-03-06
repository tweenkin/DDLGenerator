package com.lifeonwalden.codeGenerator.mybatis.impl;

import com.lifeonwalden.codeGenerator.bean.Table;
import com.lifeonwalden.codeGenerator.bean.config.Config;
import com.lifeonwalden.codeGenerator.mybatis.TableElementGenerator;
import com.lifeonwalden.codeGenerator.mybatis.constant.XMLAttribute;
import com.lifeonwalden.codeGenerator.mybatis.constant.XMLTag;
import com.lifeonwalden.codeGenerator.util.NameUtil;
import org.mybatis.generator.dom.xml.Attribute;
import org.mybatis.generator.dom.xml.XmlElement;

public class RootElementGenerator implements TableElementGenerator {

    public XmlElement getElement(Table table, Config config) {
        XmlElement element = new XmlElement(XMLTag.ROOT.getName());
        element.addAttribute(new Attribute(XMLAttribute.NAMESPACE.getName(), NameUtil.getNamespace(table, config)));

        return element;
    }
}
