package site.starsone.svg2vector.svg.shape;

import site.starsone.svg2vector.svg.SvgHelper;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;

import org.dom4j.Element;

public class Line extends BaseShape {
    @Override
    public String resolvePath(Element shape, Attributes attributes) {
        double x1 = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Line.X1);
        double y1 = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Line.Y1);
        double x2 = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Line.X2);
        double y2 = SvgHelper.getAttributeDouble(shape, ShapeAttribute.Line.Y2);
        Point startPoint = new Point(x1, y1);
        Point endPoint = new Point(x2, y2);
        attributes.matrixHelper.applyTransformToPoints(startPoint, endPoint);
        return PathBuilder.newBuilder().moveTo(startPoint)
                .lineTo(endPoint).build();
    }
}
