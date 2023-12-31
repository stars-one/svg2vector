package site.starsone.svg2vector.svg.shape;

import site.starsone.svg2vector.svg.SvgHelper;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;
import site.starsone.svg2vector.svg.constant.SupportShape;

import org.dom4j.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Poly extends BaseShape {
    private static final Pattern PATTERN = Pattern.compile("\\d+[\\s,]+\\d+");

    @Override
    String resolvePath(Element shape, Attributes attributes) {
        String points = SvgHelper.getAttributeText(shape, ShapeAttribute.Poly.POINTS);
        Matcher matcher = PATTERN.matcher(points);
        PathBuilder builder = PathBuilder.newBuilder();
        //是否移动过(是否是第一个点)
        boolean hasMoved = false;
        //polygon 时需要关闭图形
        boolean needClose = SupportShape.POLYGON.equalsIgnoreCase(shape.getName());
        while (matcher.find()) {
            String string = matcher.group(0);
            String[] xy = string.split("[\\s,]+");
            if (xy.length == 2) {
                Point point = new Point(xy[0], xy[1]);
                attributes.matrixHelper.applyTransformToPoint(point);
                if (!hasMoved) {
                    hasMoved = true;
                    builder.moveTo(point);
                } else {
                    builder.lineTo(point);
                }
            }
        }
        if (needClose && builder.length() != 0) {
            builder.close();
        }
        return builder.build();
    }
}
