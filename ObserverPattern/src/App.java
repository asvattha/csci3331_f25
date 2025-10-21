public class App {
    public static void main(String[] args) throws Exception {
        Observable ov = new Property();
        InvalidationListener listener = new Listener();
        ov.addListener(e -> System.out.println("The listener object is updated and the new value is: " + ov.get()));

        ov.set(50);

        ov.set(100);
    }
}
