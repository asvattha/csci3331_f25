public abstract class Duck {
    IFlyBehavior flyBehavior;
    IQuackBehavior quackBehavior;

    public Duck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    
    public void fly() {
        flyBehavior.fly();
        System.out.println(this.getClass().getName() + ": " + flyBehavior);
    }

    public void quack() {
        quackBehavior.quack();
        System.out.println(this.getClass().getName() + ": " + quackBehavior);
    }

    public void setFlyBehavior(IFlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(IQuackBehavior qb) {
        this.quackBehavior = qb;
    }
}
