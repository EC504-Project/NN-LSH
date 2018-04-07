import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class hashData {

    private ArrayList<double[]> bHashVectors;
    private HashMap<String,ArrayList<File>> buckets;

    public hashData(ArrayList<double[]> bHashVectors, HashMap<String, ArrayList<File>> buckets) {
        this.bHashVectors = bHashVectors;
        this.buckets = buckets;
    }

    public ArrayList<double[]> getbHashVectors() {
        return bHashVectors;
    }

    public HashMap<String, ArrayList<File>> getBuckets() {
        return buckets;
    }
}
