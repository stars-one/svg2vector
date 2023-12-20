package site.starsone.svg2vector.svg.attribute.group.transform;

import site.starsone.svg2vector.tool.MatrixHelper;

class Rotate implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        if (params.length == 1) {
            //原点旋转
            matrixHelper.preRotate(params[0], 0, 0);
        } else if (params.length == 3) {
            //某点旋转
            matrixHelper.preRotate(params[0], params[1], params[2]);
        }
    }
}
