package site.starsone.svg2vector.svg.attribute.shape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import site.starsone.svg2vector.svg.attribute.AttributeDispatcher;
import site.starsone.svg2vector.svg.attribute.IAttribute;
import site.starsone.svg2vector.svg.attribute.style.Attributes;

public class Style implements IAttribute {
    private static final Pattern PATTERN = Pattern.compile("([-\\w]+):\\s*(\\S+)");

    @Override
    public void resolve(String data, Attributes attributes) {
        String[] styles = data.split(";");
        for (String style : styles) {
            Matcher matcher = PATTERN.matcher(style.trim());
            if (matcher.find()) {
                String styleName = matcher.group(1);
                String value = matcher.group(2);
                AttributeDispatcher.dispatch(styleName, value, attributes);
            }
        }
    }
}
