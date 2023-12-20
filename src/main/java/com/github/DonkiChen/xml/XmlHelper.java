package com.github.DonkiChen.xml;

import com.github.DonkiChen.tool.TextUtils;
import com.github.DonkiChen.xml.constant.AndroidQName;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.StringWriter;

public class XmlHelper {

    private Document mXmlDocument;
    private Element mRootElement;

    public XmlHelper() {
        mXmlDocument = DocumentHelper.createDocument();
        mRootElement = mXmlDocument.addElement("vector");
        mRootElement.add(AndroidQName.ANDROID_NAMESPACE);
    }

    public void addRootAttribute(QName qName, String value) {
        mRootElement.addAttribute(qName, value);
    }

    public void addPath(XmlPathNode node) {
        if (TextUtils.isEmpty(node.data) || node.style == null) {
            return;
        }
        Element path = mRootElement.addElement("path");
        if (!TextUtils.isEmpty(node.style.fillType)) {
            //含有fillType
            path.addAttribute(AndroidQName.FILL_TYPE, node.style.fillType);
        }
        path.addAttribute(AndroidQName.FILL_COLOR, node.style.fillColor);
        if (!TextUtils.isEmpty(node.style.strokeWidth) && !"0".equals(node.style.strokeWidth)) {
            //含有边框
            path.addAttribute(AndroidQName.STROKE_COLOR, node.style.strokeColor);
            path.addAttribute(AndroidQName.STROKE_WIDTH, node.style.strokeWidth);
        }
        path.addAttribute(AndroidQName.PATH_DATA, node.data);
    }

    public String getDocumentString() {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setIndent(true);
        format.setIndentSize(2);

        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);

        try {

            xmlWriter.write(mXmlDocument);
            xmlWriter.flush();
            xmlWriter.close();
            // 输出美化后的 XML 字符串
            String formattedXml = writer.toString();
            return formattedXml;
        } catch (Exception e) {

        }
        return "";
    }
}
