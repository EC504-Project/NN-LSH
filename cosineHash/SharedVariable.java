import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;

public class SharedVariable {

    static int numberOfHashes = 4; // number of hash vectors per hash table
    static int numberOfTables = 20; // number of hash tables
    static int dimension = 1024 ; // dimension of images
    static double[] mean = new double[dimension]; // mean vector, filled with 0 for standard normal
    static RealMatrix identity = MatrixUtils.createRealIdentityMatrix(dimension); // covariance matrix
    static ArrayList<hashData> collectionOfTables = new ArrayList<>(); // collection of store and retrieval data structure
    static MultivariateNormalDistribution b = new MultivariateNormalDistribution(SharedVariable.mean, SharedVariable.identity.getData());
}
