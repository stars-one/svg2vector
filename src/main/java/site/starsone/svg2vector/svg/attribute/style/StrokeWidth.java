package site.starsone.svg2vector.svg.attribute.style;

import site.starsone.svg2vector.svg.attribute.IAttribute;

public class StrokeWidth implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        attributes.style.strokeWidth = data;
    }
}
