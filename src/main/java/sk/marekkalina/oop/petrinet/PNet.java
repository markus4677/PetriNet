package sk.marekkalina.oop.petrinet;

import sun.java2d.loops.TransformBlit;

import java.util.ArrayList;
import java.util.List;

public class PNet extends PetriObject {

    List<Place> spots = new ArrayList<Place>();
    List<Transition> trans = new ArrayList<Transition>();
    List<Arc> arcs = new ArrayList<Arc>();
    List<ResetArc> reset_arcs = new ArrayList<ResetArc>();

    //Place miesto = new Place("strom",15 );
    //Place miesto=spots

    //    public void AddPlace(String name, long ID,int tokens) {
//        Place p = new Place(name,ID);
//        p.addTokens(tokens);
//        spots.add(p);
//    }
//    public List<Arc> getArcs() {
//        if (arcs == null) {
//            arcs = new ArrayList<Arc>();
//        }
//        return this.arcs;
//    }


    protected int j;

    public Place getPlaceByID(long ID) {

        for (Place pp : spots) {
            if (pp.getID() == ID) {
                j = spots.indexOf(pp);
            } else continue;
        }
        return spots.get(j);
    }


    protected int i;

    public Transition getTransitionByID(long ID) {

        for (Transition tt : trans) {
            if (tt.getID() == ID) {
                i = trans.indexOf(tt);
            } else continue;
        }
        return trans.get(i);
    }

//
//    public int gettokensbyid(String name,long ID){
//            this.name=name;
//            this.ID=ID;
//            int num=0;
//        for(Place plac:spots)
//            {
//                if(plac.getID()==ID) num=plac.getTokens();
//            }
//            return num;
//    }

    public void addPlace(Place place) {


        spots.add(place);
    }


    public void addTransition(Transition transs) {
        trans.add(transs);
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }


    public List<Place> getPlaces() {
        return spots;
    }

    public List<Transition> getTransitions() {
        return trans;
    }

    private boolean state = false;


    public Place place(String name, long ID) {
        Place p = new Place(name, ID);
        spots.add(p);
        return p;
    }

    public Transition trans(String name, long ID) {
        Transition t = new Transition(name, ID);
        trans.add(t);

        return t;
    }

    public Arc arc(Place p, Transition t) {
        Arc arc = new Arc(p, t);
        arcs.add(arc);
        return arc;
    }

    public Arc arc(Transition t, Place p) {
        Arc arc = new Arc(t, p);
        arcs.add(arc);
        return arc;
    }

    public ResetArc resetarc(Place p, Transition t) {
        ResetArc resetarc = new ResetArc(p, t);
        return resetarc;
    }


//    public void add(Place spott)
//    {
//        spots.add((Place) spott);
//    }
//    public void add(Transition tt)
//    {
//        trans.add((Transition) tt);
//    }


//    public PNet(String name, long ID) {
//        super(name, ID);
//    }


    public void fire(long ID) {
        for (Transition T : trans) {
            if (ID == T.getID()) {
                T.fire();
            }
        }
    }


    @Override
    public String toString() {
        return "PNet{" +
                "name='" + name + '\'' +
                ", spots=" + spots +
                ", trans=" + trans +
                ", arcs=" + arcs +
                ", reset_arcs=" + reset_arcs +
                '}';
    }
}
