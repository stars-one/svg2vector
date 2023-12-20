package site.starsone.svg2vector.svg.shape;

import site.starsone.svg2vector.svg.SvgHelper;
import site.starsone.svg2vector.svg.attribute.AttributeDispatcher;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;
import site.starsone.svg2vector.svg.constant.StyleAttribute;
import site.starsone.svg2vector.xml.XmlPathNode;

import org.dom4j.Attribute;
import org.dom4j.Element;


public abstract class BaseShape {

    public XmlPathNode toPathNode(Element shape, Attributes attributes) {
        XmlPathNode xmlPathNode = new XmlPathNode();
        xmlPathNode.style = resolveChildStyle(shape, attributes).style;
        xmlPathNode.data = resolvePath(shape, attributes);
        return xmlPathNode;
    }

    /**
     * 将当前形状转换为Path
     *
     * @param shape      当前元素
     * @param attributes 父类的属性
     * @return 转换后的节点
     */
    abstract String resolvePath(Element shape, Attributes attributes);

    public Attributes resolveChildStyle(Element shape, Attributes attributes) {
        Attribute childStyleAttribute = shape.attribute(ShapeAttribute.STYLE);
        Attribute childTransformAttribute = shape.attribute(StyleAttribute.TRANSFORM);
        if (childStyleAttribute == null && childTransformAttribute == null) {
            return attributes;
        }
        //继承group样式
        Attributes childAttributes = attributes.copy();
        if (childStyleAttribute != null) {
            //修改自己的样式
            AttributeDispatcher.dispatch(childStyleAttribute.getName(),
                    SvgHelper.getAttributeText(shape, ShapeAttribute.STYLE),
                    childAttributes);
        }
        if (childTransformAttribute != null) {
            //自己的变换
            AttributeDispatcher.dispatch(childTransformAttribute.getName(),
                    SvgHelper.getAttributeText(shape, StyleAttribute.TRANSFORM),
                    childAttributes);
        }
        return childAttributes;
    }
}
