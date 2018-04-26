import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

import java.io.File;
import java.io.IOException;

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
        return SharedVariable.b.sample();
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

    public static void main(String[] args) throws IOException {
        double[] testR = generateGaussianVector();
        File a = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image\\5_15952.jpg");
        double []fake_image = img2vec.img2vec(a);
//        System.out.println("Vector r is ");
//        for(double b : testR){
//            System.out.println(b);
//        }
//        System.out.println("Vector image is ");
//        for(double b : fake_image){
//            System.out.println(b);
//        }
        double result = dotProduct(testR,fake_image);
        System.out.println("dot result is "+ result);
        System.out.println("hash result is "+ hash(fake_image,testR));
    }
}
