package com.github.DonkiChen.svg.shape.path;

import com.github.DonkiChen.svg.bean.Point;
import com.github.DonkiChen.tool.MatrixHelper;

/**
 * L/l
 * x,y
 */
class LineTo extends BasePath {
    @Override
    public PathState performTransform(PathState pathState, String command, String[] values, MatrixHelper matrixHelper) {
        Point point = pathState.lastPoint;
        if (values.length == 2) {
            StringBuilder path = new StringBuilder();
            path.append("L");
            calLastPoint(point, command, values[0], values[1], matrixHelper);
            path.append(point.toString());
            pathState.transformedPath = path.toString();
        }
        return pathState;
    }
}
