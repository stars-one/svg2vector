package site.starsone.svg2vector.svg;

import org.dom4j.Attribute;
import org.dom4j.Element;

import site.starsone.svg2vector.tool.MathHelper;

public class SvgHelper {
    public static String getAttributeText(Element element, String attributeKey) {
        return getAttributeText(element, attributeKey, "");
    }

    public static String getAttributeText(Element element, String attributeKey, String defaultValue) {
        Attribute attribute = element.attribute(attributeKey);
        if (attribute != null) {
            return attribute.getText();
        }
        return defaultValue;
    }

    public static double getAttributeDouble(Element element, String attributeKey) {
        return MathHelper.parseDouble(getAttributeText(element, attributeKey, "0"));
    }
}
