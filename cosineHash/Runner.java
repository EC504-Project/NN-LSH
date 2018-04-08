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

    public static void main(String[] args) {
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
        double[] fake_image  = { 14,172,153};
        double[] fake_image2 = { 88,  4,200};
        String index1 = "";
        String index2 = "";
        for(hashData a: SharedVariable.collectionOfTables){
            for (double[] r:a.getbHashVectors()) {
                index1 += CosineHashFamily.hash(fake_image,r);
            }
            System.out.println("fake_image is " + index1);
            a.getM().put(index1, fake_image);
        }
        for(hashData a: SharedVariable.collectionOfTables){
            for (double[] r:a.getbHashVectors()) {
                index2 += CosineHashFamily.hash(fake_image2,r);
            }
            System.out.println("fake_image2 is " + index2);
            a.getM().put(index2, fake_image2);
        }
        ArrayList<double[]> re_fake_1 = (ArrayList<double[]>) SharedVariable.collectionOfTables.get(0).getM().get(index1);
        ArrayList<double[]> re_fake_2 = (ArrayList<double[]>) SharedVariable.collectionOfTables.get(0).getM().get(index2);
        System.out.println("fake 1:");
        for(double[] a: re_fake_1){
            for(double b: a){
                System.out.println(b);
            }
        }
        System.out.println("fake 2:");
        for(double[] a: re_fake_2){
            for(double b: a){
                System.out.println(b);
            }
        }
    }

}
