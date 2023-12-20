package site.starsone.svg2vector.svg.attribute.style;


import site.starsone.svg2vector.svg.attribute.IAttribute;
import site.starsone.svg2vector.svg.constant.StyleValue;

public class FillRule implements IAttribute {
    @Override
    public void resolve(String data, Attributes attributes) {
        if (StyleValue.FillRule.EVEN_ODD.equalsIgnoreCase(data)) {
            attributes.style.fillType = StyleValue.FillRule.EVEN_ODD;
        } else if (StyleValue.FillRule.NON_ZERO.equalsIgnoreCase(data)) {
            attributes.style.fillType = StyleValue.FillRule.NON_ZERO;
        }
    }
}
