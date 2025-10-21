import java.util.ArrayList;

public class Property implements Observable {

    ArrayList<InvalidationListener> listeners = new ArrayList<>();
    double value = 0;

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        int ix = listeners.indexOf(listener);
        listeners.remove(ix);
    }

    @Override
    public void informAll() {
        for(InvalidationListener e: listeners) {
            e.invalidated(this);
        }
    }

    @Override
    public void set(double value) {
        this.value = value;
        informAll();
    }

    public double get() {
        return value;
    }
    
}
