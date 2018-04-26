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
        /*
         * Read all images files from folder
         * hash each images and put them into the table;
         */
        File folder = new File("C:\\Users\\ryanr\\IdeaProjects\\NN-LSH\\image2vector\\image");
        File image;
        String[] fileList = folder.list();
        double[] imageVector;
        String image_Index = "";
        for (String filename: fileList){
            if (filename.endsWith(".jpg")){
                System.out.println(filename);
                image = new File(folder.getAbsolutePath() + "\\" + filename);
                imageVector = img2vec.img2vec(image);
                for(hashData a: SharedVariable.collectionOfTables){
                    for (double[] r:a.getbHashVectors()) {
                        image_Index += CosineHashFamily.hash(imageVector,r);
                    }
                    System.out.println("image is " + image_Index);
                    a.getM().put(image_Index, image);
                    image_Index = "";
                }
            }
        }
    }

}
