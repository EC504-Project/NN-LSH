import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

public class CosineHashFamily {

    /**
     * dot product between two 1*N vectors
     * @param vectorOne 1*N vectors
     * @param VectorTwo 1*N vectors
     * @return double
     */
    public static double dotProduct(double[] vectorOne, double[] VectorTwo) {
        double sum = 0;
        for (int i = 0; i < vectorOne.length; i++) {
            sum += vectorOne[i]*VectorTwo[i];
        }
        return sum;
    }

    /**
     * Generate a vector from N(0,I) distribution, where I has the same dimension as images
     * @return double[]
     */
    public static double[] generateGaussianVector() {
        MultivariateNormalDistribution b = new MultivariateNormalDistribution(SharedVariable.mean, SharedVariable.identity.getData());
        return b.sample();
    }

    /**
     * Apply dot product between image and vector r, return 1 if the product is greater than 0, 0 otherwise
     * @param image 1*N vector
     * @param r 1*N vector
     * @return int
     */
    public static int hash(double[] image, double[] r) {
        double dotResult = dotProduct(image,r);
        if (dotResult > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        double[] testR = generateGaussianVector();
        double []fake_image = {1,256,30};
        System.out.println("Vector r is ");
        for(double a : testR){
            System.out.println(a);
        }
        System.out.println("Vector image is ");
        for(double a : fake_image){
            System.out.println(a);
        }
        double result = dotProduct(testR,fake_image);
        System.out.println("dot result is "+ result);
        System.out.println("hash result is "+ hash(fake_image,testR));
    }
}
