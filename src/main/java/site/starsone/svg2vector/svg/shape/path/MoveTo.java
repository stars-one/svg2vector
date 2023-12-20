package site.starsone.svg2vector.svg.shape.path;

import site.starsone.svg2vector.svg.bean.Point;
import site.starsone.svg2vector.tool.MatrixHelper;

/**
 * M/m
 * x,y
 */
class MoveTo extends BasePath {

    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 2) {
            StringBuilder path = new StringBuilder();
            path.append("M");
            calLastPoint(point, command, values[0], values[1], matrixHelper);
            path.append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
