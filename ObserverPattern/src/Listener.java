public class Listener implements InvalidationListener {

    @Override
    public void invalidated(Observable ov) {
        update(ov);
    }

    public void update(Observable ov) {
        System.out.println("The listener object is updated and the new value is: " + ov.get());
    }
    
}
