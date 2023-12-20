package site.starsone.svg2vector.svg.attribute;


import site.starsone.svg2vector.svg.attribute.style.Attributes;

public interface IAttribute {
    void resolve(String data, Attributes attributes);
}
