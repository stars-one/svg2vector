package site.starsone.svg2vector.svg.attribute.group.transform;


import site.starsone.svg2vector.tool.MatrixHelper;

interface ITransform {
    void transformMatrix(MatrixHelper matrixHelper, double[] params);
}
