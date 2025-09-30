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

Now imagine the client comes back with more changes. This time, they want MallardDuck and RedheadDuck to have different flying behaviors. On top of that, they ask you to add a new duck called DecoyDuck, which should now fly the same way as RedheadDuck.

So, how do you handle this in your current design?

You might consider overriding the fly method in both RedheadDuck and DecoyDuck. But doing that would mean duplicating the same flying code in multiple classes — which isn't ideal.
Maybe you think of creating a new superclass to hold the shared flying behavior and make both RedheadDuck and DecoyDuck inherit from it. That works for now, but what happens when requirements change again?

For example, in the future:
- RedheadDuck’s flying behavior might change again.
- A new set of ducks might need to adopt this new behavior.
- Some ducks might need yet another flying style.

Every time that happens, you'd have to:
- Rewrite or update multiple classes.
- Restructure inheritance trees.
- Deal with tight coupling and duplicated logic.

If you continue to rely on inheritance, you'll quickly run into a web of dependencies and repetitive code — making your design rigid and hard to maintain.
This leads to a key insight: inheritance alone isn’t flexible enough for modeling behaviors that can vary and evolve independently across many objects. To solve this, we need a better design approach — one that promotes reuse without coupling and makes it easier to change behaviors without rewriting existing code.

Design Principles: 
1. Encapsulate what varies: To solve the design problem we discussed earlier, a good approach is to separate out the parts of the code that change frequently — in this case, the fly and quack behaviors.
Instead of hardcoding these behaviors in the Duck subclasses, we can move them into separate classes. But should we group them together or keep them separate?
Since flying and quacking are two different behaviors — each with its own set of variations (or algorithms) — and they don’t depend on each other, it makes sense to encapsulate them individually.
We can do this by creating two separate interfaces, for example:
- IFlyBehavior for flying styles
- IQuackBehavior for quacking styles

2. Code to abstraction than implementation: Why using interfaces? This is because we want to follow the principle where we want to code to the abstraction(abstract class/interfaces) than implementation(concreate classes). 

Each duck can then be composed of these behavior objects rather than inheriting behavior from a parent class. This way, we gain flexibility and can mix and match behaviors easily without duplicating code.
This idea is implemented in commit "v3", where the behavior changes are encapsulated into separate classes.

2. Favor composition/aggregation/association over inheritance: Each duck is now composed of these behavior objects (IFlyBehavior and IQuackBehavior) than inheriting them as shown in the code. By using composition, it also gives us the flexibility to modify a different fly or quack behavior to a duck on-fly at runtime.  This is illustrated in the commit "v3"
*/

public class App {
    public static void main(String[] args) throws Exception {
        Duck d1 = new MallardDuck(new FlyWithWings(), new Quack());
        Duck d2 = new RedheadDuck(new FlyWithWings(), new Quack());
        Duck d3 = new RubberDuck(new DoNotFly(), new Squeak());
        d1.fly();
        d2.quack();

        d3.fly(); 
        d3.quack();

        // changing behavior during runtime

        d2.setFlyBehavior(new FlyWithSpeed());
        d2.fly();
    }
}
