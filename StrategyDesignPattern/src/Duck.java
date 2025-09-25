public abstract class Duck {
    
    public void fly() {
        System.out.println(this.getClass().getName() + " is flying");
    }

    public void quack() {
        System.out.println(this.getClass().getName() + " is making sound: Quack Quack");
    }
}
