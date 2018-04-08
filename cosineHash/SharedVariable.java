import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;

public class SharedVariable {

    static int numberOfHashes = 3; // number of hash vectors per hash table
    static int numberOfTables = 50; // number of hash tables
    static int dimension = 3 ; // dimension of images
    static double[] mean = new double[dimension]; // mean vector, filled with 0 for standard normal
    static RealMatrix identity = MatrixUtils.createRealIdentityMatrix(dimension); // covariance matrix
    static ArrayList<hashData> collectionOfTables = new ArrayList<>(); // collection of store and retrieval data structure
}
