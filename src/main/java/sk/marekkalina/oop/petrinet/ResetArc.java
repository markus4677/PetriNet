package sk.marekkalina.oop.petrinet;

public class ResetArc extends PetriObject {


    private int weight = 0;
    private Place spot;
    private Transition trans;


    public void fire(Place spot) {
        spot.setTokens(0);
    }


    public ResetArc(Place spot, Transition trans) {
        this.spot = spot;
        this.trans = trans;
        trans.addResetArc(this);

    }


    public void fire() {
        this.fire(spot);
    }

}
