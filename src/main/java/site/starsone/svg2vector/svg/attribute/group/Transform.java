package site.starsone.svg2vector.svg.attribute.group;

import site.starsone.svg2vector.svg.attribute.IAttribute;
import site.starsone.svg2vector.svg.attribute.group.transform.TransformDispatcher;
import site.starsone.svg2vector.svg.attribute.style.Attributes;

public class Transform implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        TransformDispatcher.dispatch(data, attributes.matrixHelper);
    }
}
