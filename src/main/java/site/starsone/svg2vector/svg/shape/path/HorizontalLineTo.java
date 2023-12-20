package site.starsone.svg2vector.svg.shape.path;

import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.tool.MathHelper;
import site.starsone.svg2vector.tool.MatrixHelper;

/**
 * H/h
 * x
 */
class HorizontalLineTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 1) {
            StringBuilder path = new StringBuilder();
            path.append("H");
            calLastPoint(point, command, values[0], "0", matrixHelper);
            path.append(MathHelper.prettyDouble(point.x));
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
