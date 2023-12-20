package site.starsone.svg2vector.svg.attribute.group.transform;


import site.starsone.svg2vector.tool.MatrixHelper;

class MatrixTransform implements ITransform {
    @Override
    public void transformMatrix(MatrixHelper matrixHelper, double[] params) {
        //a c e
        //b d f
        if (params.length == 6) {
            matrixHelper.transform(new double[]{
                    params[0], params[2], params[4]
            }, new double[]{
                    params[1], params[3], params[5]
            });
        }
    }
}
