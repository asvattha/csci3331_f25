/*
This example has been taken from the Head First Design Pattern Book. You are encouraged to read the first chapter of the book 
to under this design pattern, and also some of the design principles that goes behind writing a Object-oriented program. 


Suppose you are asked to create a Duck simulator for a game, where there are various duck objects which are expected to fly or quack
in the game. Suppose the client asks you to create two specific ducks that they need in the game i.e MallardDuck and RedheadDuck that 
flies and quacks the same way.

Your earlier thought would be to simply create a Duck parent class and have those MallardDuck and RedheadDuck inherit this class, such that
they both inherit those behaviors. This will help with no duplicate code. And your client is happy.  This is illustrated in the commit v1.
*/

public class App {
    public static void main(String[] args) throws Exception {
        Duck d1 = new MallardDuck();
        Duck d2 = new RedheadDuck();
        d1.fly();
        d2.quack();
    }
}
