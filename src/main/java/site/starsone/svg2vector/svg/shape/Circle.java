package site.starsone.svg2vector.svg.shape;

import site.starsone.svg2vector.svg.SvgHelper;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;

import org.dom4j.Element;

public class Circle extends BaseShape {
    @Override
    public String resolvePath(Element shape, Attributes attributes) {
        double cx = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Circle.CX);
        double cy = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Circle.CY);
        double rx = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Circle.R);
        double ry = rx;
        Point point = new Point(cx, cy);
        rx = attributes.matrixHelper.applyTransformRx(rx);
        ry = attributes.matrixHelper.applyTransformRx(ry);
        attributes.matrixHelper.applyTransformToPoint(point);
        return PathBuilder.newBuilder()
                .moveTo(point)
                .rMoveTo(-rx, 0)
                .rArcTo(rx, ry, 2 * rx, 0)
                .rArcTo(rx, ry, -2 * rx, 0)
                .build();
    }
}
