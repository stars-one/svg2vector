package site.starsone.svg2vector.svg.attribute;

import site.starsone.svg2vector.svg.attribute.group.Transform;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import site.starsone.svg2vector.svg.attribute.shape.PathData;
import site.starsone.svg2vector.svg.attribute.shape.Style;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.attribute.style.FillColor;
import site.starsone.svg2vector.svg.attribute.style.FillRule;
import site.starsone.svg2vector.svg.attribute.style.StrokeColor;
import site.starsone.svg2vector.svg.attribute.style.StrokeWidth;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;
import site.starsone.svg2vector.svg.constant.StyleAttribute;

public class AttributeDispatcher {
    private static final Map<String, IAttribute> ATTRIBUTE_MAP = new HashMap<>();

    static {
        ATTRIBUTE_MAP.put(StyleAttribute.FILL, new FillColor());
        ATTRIBUTE_MAP.put(StyleAttribute.FILL_RULE, new FillRule());
        ATTRIBUTE_MAP.put(StyleAttribute.STROKE, new StrokeColor());
        ATTRIBUTE_MAP.put(StyleAttribute.STROKE_WIDTH, new StrokeWidth());
        ATTRIBUTE_MAP.put(StyleAttribute.TRANSFORM, new Transform());
        ATTRIBUTE_MAP.put(ShapeAttribute.D, new PathData());
        ATTRIBUTE_MAP.put(ShapeAttribute.STYLE, new Style());
    }

    /**
     * attributes属性填充
     */
    public static void dispatch(String name, String value, Attributes attributes) {
        IAttribute iAttribute = ATTRIBUTE_MAP.get(name.toLowerCase(Locale.CHINA));
        if (iAttribute != null) {
            iAttribute.resolve(value.trim(), attributes);
        }
    }
}
