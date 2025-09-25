public class RubberDuck extends Duck{
    @Override
    public void fly() {}

    @Override
    public void quack() {
        System.out.println(this.getClass().getName() + " is making sound: Squeak Squeak");
    }
}