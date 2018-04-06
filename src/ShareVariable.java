import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class ShareVariable {
    static int dimension = 3;
    static double[] mean = new double[dimension];
    static RealMatrix identity = MatrixUtils.createRealIdentityMatrix(dimension);
}
