import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

public class CosineHashFamily {

    public static double dotProduct(double[] vectorOne, double[] VectorTwo) {
        double sum = 0;
        for (int i = 0; i < vectorOne.length; i++) {
            sum += vectorOne[i]*VectorTwo[i];
        }
        return sum;
    }

    public static double[] generateGaussianVector() {
        MultivariateNormalDistribution b = new MultivariateNormalDistribution(ShareVariable.mean,ShareVariable.identity.getData());
        return b.sample();
    }

    public static int hash(double[] image) {
        double[] r = generateGaussianVector();
        double dotResult = dotProduct(image,r);
        if (dotResult > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
