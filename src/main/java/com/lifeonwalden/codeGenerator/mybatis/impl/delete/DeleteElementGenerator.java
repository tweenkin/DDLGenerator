package com.lifeonwalden.codeGenerator.mybatis.impl.delete;

import com.lifeonwalden.codeGenerator.bean.Table;
import com.lifeonwalden.codeGenerator.bean.config.Config;
import com.lifeonwalden.codeGenerator.constant.DefinedMappingID;
import com.lifeonwalden.codeGenerator.mybatis.TableElementGenerator;
import com.lifeonwalden.codeGenerator.mybatis.constant.XMLAttribute;
import com.lifeonwalden.codeGenerator.mybatis.constant.XMLTag;
import com.lifeonwalden.codeGenerator.util.BatisMappingUtil;
import com.lifeonwalden.codeGenerator.util.NameUtil;
import org.mybatis.generator.dom.xml.Attribute;
import org.mybatis.generator.dom.xml.TextElement;
import org.mybatis.generator.dom.xml.XmlElement;

public class DeleteElementGenerator implements TableElementGenerator {

    public XmlElement getElement(Table table, Config config) {
        XmlElement element = new XmlElement(XMLTag.DELETE.getName());
        String className = config.getBeanInfo().getPackageName() + "." + NameUtil.getResultBeanName(table, config);

        element.addAttribute(new Attribute(XMLAttribute.ID.getName(), DefinedMappingID.DELETE));
        element.addAttribute(new Attribute(XMLAttribute.PARAMETER_TYPE.getName(), className));

        XmlElement deleteSQL = new XmlElement(XMLTag.INCLUDE.getName());
        deleteSQL.addAttribute(new Attribute(XMLAttribute.REF_ID.getName(), DefinedMappingID.DELETE_SQL));
        element.addElement(deleteSQL);

        element.addElement(new TextElement(BatisMappingUtil.primaryKeyFragment(table)));

        return element;
    }
}
