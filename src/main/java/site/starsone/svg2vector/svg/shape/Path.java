package site.starsone.svg2vector.svg.shape;

import site.starsone.svg2vector.svg.SvgHelper;
import site.starsone.svg2vector.svg.attribute.style.Attributes;
import site.starsone.svg2vector.svg.constant.ShapeAttribute;
import site.starsone.svg2vector.svg.shape.path.BasePath;
import site.starsone.svg2vector.svg.shape.path.PathDispatcher;
import site.starsone.svg2vector.tool.TextUtils;

import org.dom4j.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path extends BaseShape {
    private static final Pattern PATTERN = Pattern.compile("(([a-zA-Z])([-0-9.,\\s]+)|Z)");

    @Override
    public String resolvePath(Element shape, Attributes attributes) {
        Matcher matcher = PATTERN.matcher(SvgHelper.getAttributeText(shape, ShapeAttribute.D));
        StringBuilder path = new StringBuilder();
        BasePath.PathState pathState = new BasePath.PathState();
        while (matcher.find()) {
            String fullCommand = matcher.group(1);
            String command = matcher.group(2);
            String value = matcher.group(3);
            if (TextUtils.isEmpty(command) || TextUtils.isEmpty(value)) {
                //Z
                if ("z".equalsIgnoreCase(fullCommand.trim())) {
                    path.append("Z");
                }
            } else {
                //非Z
                pathState = PathDispatcher.dispatch(pathState, command, value.trim(), attributes.matrixHelper);
                path.append(pathState.transformedPath);
            }
        }
        return path.toString();
    }
}
