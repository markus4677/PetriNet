package sk.marekkalina.oop.petrinet;

import sun.java2d.loops.TransformBlit;

public class Arc extends PetriObject {

    private int weight = 1;
    private direction dir;
    private Place spot;
    private Transition trans;


//explicitné volanie konštruktora

    enum direction {

        PLACE_TO_TRANSITION {
            public boolean fire_test(Place p, int weight) {
                return p.test_tokens(weight);
            }

            public void fire(Place p, int weight) {
                p.removeTokens(weight);
            }
        },
        TRANSITION_TO_PLACE {
            public boolean fire_test(Place p, int weight) {
                return true;
            }

            public void fire(Place p, int weight) {
                p.addTokens(weight);
            }

        };

        public abstract boolean fire_test(Place p, int weight);

        public abstract void fire(Place p, int weight);
    }


    public int getWeight() {
        return weight;
    }


    public Place getSpot() {
        return spot;
    }


    private Arc(direction direct, Place spott, Transition transs) {
        this.dir = direct;
        this.spot = spott;
        this.trans = transs;
    }

    public Arc(Place spot, Transition trans) {
        this(direction.PLACE_TO_TRANSITION, spot, trans);
        trans.addInputArcs(this);

    }


    public Arc(Transition trans, Place spot) {
        this(direction.TRANSITION_TO_PLACE, spot, trans);
        trans.addOutputArcs(this);
    }

    public boolean fire_test() {
        return dir.fire_test(spot, weight);
    }

    public void fire() {
        this.dir.fire(spot, this.weight);
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Arc{" +
                "weight=" + weight +
                ", spot=" + spot +
                ", trans=" + trans +
                '}';
    }
}
