import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Runner {

    /**
     * Write obj to path specified
     * @param path path to write obj
     * @param obj object to be written
     */
    public static void writeOutObjects(String path, Object obj){
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        /*
         * Create L hash table, each with b hash vectors
         */
        for (int i = 0; i < SharedVariable.numberOfTables; i++) {
            ArrayList<double[]> bHashVectors = new ArrayList<>();
            for (int j = 0; j < SharedVariable.numberOfHashes; j++) {
                bHashVectors.add(CosineHashFamily.generateGaussianVector());
            }
            SharedVariable.collectionOfTables.add(new hashData(bHashVectors,new MultiValueMap()));
        }
//        double []fake_image = img2vec.img2vec("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image\\5_15952.jpg");
//        double[] fake_image2 = img2vec.img2vec("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image\\5_15952.jpg");
//        double []fake_image3 = img2vec.img2vec("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image\\5_15952.jpg");
//        double[] fake_image4 = img2vec.img2vec("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image\\5_15952.jpg");
//        String index1 = "";
//        String index2 = "";
//        String index3 = "";
//        String index4 = "";
//        for(hashData a: SharedVariable.collectionOfTables){
//            for (double[] r:a.getbHashVectors()) {
//                index1 += CosineHashFamily.hash(fake_image,r);
//            }
//            System.out.println("fake_image is " + index1);
//            a.getM().put(index1, fake_image);
//            index1 = "";
//        }
//        for(hashData a: SharedVariable.collectionOfTables){
//            for (double[] r:a.getbHashVectors()) {
//                index2 += CosineHashFamily.hash(fake_image2,r);
//            }
//            System.out.println("fake_image2 is " + index2);
//            a.getM().put(index2, fake_image2);
//            index2 = "";
//        }
//        for(hashData a: SharedVariable.collectionOfTables){
//            for (double[] r:a.getbHashVectors()) {
//                index3 += CosineHashFamily.hash(fake_image3,r);
//            }
//            System.out.println("fake_image3 is " + index3);
//            a.getM().put(index3 ,fake_image3);
//            index3 = "";
//        }
//        for(hashData a: SharedVariable.collectionOfTables){
//            for (double[] r:a.getbHashVectors()) {
//                index4 += CosineHashFamily.hash(fake_image4,r);
//            }
//            System.out.println("fake_image4 is " + index4);
//            a.getM().put(index4 ,fake_image3);
//            index4 = "";
//        }
    }

}
