package site.starsone.svg2vector.svg.shape.path;

import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.tool.MathHelper;
import site.starsone.svg2vector.tool.MatrixHelper;

/**
 * V/v
 * y
 */
class VerticalLineTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 1) {
            StringBuilder path = new StringBuilder();
            path.append("V");
            calLastPoint(point, command, "0", values[0], matrixHelper);
            path.append(MathHelper.prettyDouble(point.y));
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
