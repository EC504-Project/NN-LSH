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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<double[]> bHashVectors = new ArrayList<>();
        for (int i = 0; i < SharedVariable.numberOfTables; i++) {
            for (int j = 0; j < SharedVariable.numberOfHashes; j++) {
                bHashVectors.add(CosineHashFamily.generateGaussianVector());
            }
            SharedVariable.collectionOfTables.add(new hashData(bHashVectors,new MultiValueMap()));
            bHashVectors.clear();
        }

    }

}
