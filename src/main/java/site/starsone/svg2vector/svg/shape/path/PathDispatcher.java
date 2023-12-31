package site.starsone.svg2vector.svg.shape.path;

import site.starsone.svg2vector.svg.constant.PathCommand;
import site.starsone.svg2vector.tool.MatrixHelper;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PathDispatcher {
    private static final Map<String, BasePath> COMMAND_MAP = new HashMap<>();

    static {
        COMMAND_MAP.put(PathCommand.MOVE_TO, new MoveTo());
        COMMAND_MAP.put(PathCommand.LINE_TO, new LineTo());
        COMMAND_MAP.put(PathCommand.HORIZONTAL_LINE_TO, new HorizontalLineTo());
        COMMAND_MAP.put(PathCommand.VERTICAL_LINE_TO, new VerticalLineTo());
        COMMAND_MAP.put(PathCommand.CUBIC_BEZIER_CURVE_TO, new CubicBezierCurveTo());
        COMMAND_MAP.put(PathCommand.SMOOTH_CUBIC_BEZIER_CURVE_TO, new SmoothCubicBezierCurveTo());
        COMMAND_MAP.put(PathCommand.QUAD_BEZIER_CURVE_TO, new QuadBezierCurveTo());
        COMMAND_MAP.put(PathCommand.SMOOTH_QUAD_BEZIER_CURVE_TO, new SmoothQuadBezierCurveTo());
        COMMAND_MAP.put(PathCommand.ARC_TO, new ArcTo());
    }

    //分配到对应的类中
    public static BasePath.PathState dispatch(BasePath.PathState pathState, String command,
                                              String value, MatrixHelper matrixHelper) {
        if (pathState == null) {
            pathState = new BasePath.PathState();
        }
        //清除路径,保留上一次的最后坐标点
        pathState.cleanPath();
        BasePath basePath = COMMAND_MAP.get(command.toUpperCase(Locale.CHINA));
        if (basePath != null) {
            String[] values = value.split("[\\s,]+");
            basePath.performTransform(pathState, command, values, matrixHelper);
        }
        return pathState;
    }
}
