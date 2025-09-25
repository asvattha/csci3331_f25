/*
This example has been taken from the Head First Design Pattern Book. You are encouraged to read the first chapter of the book 
to under this design pattern, and also some of the design principles that goes behind writing a Object-oriented program. 


Suppose you are asked to create a Duck simulator for a game, where there are various duck objects which are expected to fly or quack
in the game. Suppose the client asks you to create two specific ducks that they need in the game i.e MallardDuck and RedheadDuck that 
flies and quacks the same way.

Your earlier thought would be to simply create a Duck parent class and have those MallardDuck and RedheadDuck inherit this class, such that
they both inherit those behaviors. This will help with no duplicate code. And your client is happy.  This is illustrated in the commit v1.

One thing that always remains true in software development is change. Imagine the game becomes a big hit, and now users want a RubberDuck that doesn’t fly and has a different quack behavior.
Since your current design is heavily based on inheritance, you’d have to override the fly and quack methods in the RubberDuck class, as shown in commit v2.
The issue now is that RubberDuck contains a fly method that essentially does nothing. This can be misleading, because from the user's perspective, it looks like RubberDuck can fly—since the method exists and can be called—but in reality, it has no effect.
*/

public class App {
    public static void main(String[] args) throws Exception {
        Duck d1 = new MallardDuck();
        Duck d2 = new RedheadDuck();
        Duck d3 = new RubberDuck();
        d1.fly();
        d2.quack();

        d3.fly(); // doesn't make sense to call this fly() method on RubberDuck
        d3.quack();
    }
}
