import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.collections4.*;

public class hashData implements Serializable {
    private MultiMap m;
    private ArrayList<double[]> bHashVectors;

    public hashData(ArrayList<double[]> bHashVectors, MultiMap m) {
        this.bHashVectors = bHashVectors;
        this.m = m;
    }

    public ArrayList<double[]> getbHashVectors() {
        return bHashVectors;
    }

    public MultiMap getM() {
        return m;
    }
}
