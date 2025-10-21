public interface Observable {
    public void addListener(InvalidationListener listener);
    void removeListener(InvalidationListener listener);
    void informAll();
    void set(double value);
    double get();
}
