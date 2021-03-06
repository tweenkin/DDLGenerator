package com.lifeonwalden.codeGenerator.mybatis.impl.select;

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

public class DirectGetElementGenerator implements TableElementGenerator {

    public XmlElement getElement(Table table, Config config) {
        XmlElement element = new XmlElement(XMLTag.SELECT.getName());

        element.addAttribute(new Attribute(XMLAttribute.ID.getName(), DefinedMappingID.DIRECT_GET));
        element.addAttribute(new Attribute(XMLAttribute.PARAMETER_TYPE.getName(), NameUtil.getClassName(table, config)));
        element.addAttribute(new Attribute(XMLAttribute.RESULT_MAP.getName(), DefinedMappingID.BASE_RESULT_MAP));

        XmlElement includeQuery = new XmlElement(XMLTag.INCLUDE.getName());
        includeQuery.addAttribute(new Attribute(XMLAttribute.REF_ID.getName(), DefinedMappingID.DIRECT_QUERY_SQL));
        element.addElement(includeQuery);

        TextElement fromElement = new TextElement(BatisMappingUtil.primaryKeyFragment(table));
        element.addElement(fromElement);

        return element;
    }
}
