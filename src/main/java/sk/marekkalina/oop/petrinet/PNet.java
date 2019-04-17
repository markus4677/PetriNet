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
//    public Place getPlaceByID(long ID)
//    {
//        Place temp = new Place("NULL",404);
//        for(Place plac:spots)
//        {
//            if(plac.getID()==ID) temp=plac;
//            else return temp;
//        }
//        return temp;
//    }

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

    public void addPlace(Place place)
    {

        //Place spot = new Place(name,ID);
        spots.add(place);
    }

    public void addTransition(Transition transs)
    {
        trans.add(transs);
    }


    public List<Place> getPlaces()
    {
        return spots;
    }
    public List<Transition> getTransitions()
    {
        return trans;
    }


    public Place place(String name, long ID) {
        Place p = new Place(name,ID);
        spots.add(p);
        return p;
    }
    public Transition trans(String name, long ID)
    {
        Transition t = new Transition(name, ID);
        trans.add(t);

        return t;
    }

    public Arc arc(Place p, Transition t)
    {
        Arc arc = new Arc(p,t);
        arcs.add(arc);
        return arc;
    }
    public Arc arc(Transition t, Place p)
    {
        Arc arc = new Arc(t,p);
        arcs.add(arc);
        return arc;
    }

    public ResetArc resetarc(Place p, Transition t)
    {
      ResetArc resetarc = new ResetArc(p,t);
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




    public void fire(long ID)
    {
        for (Transition T : trans)
        {
           if(ID== T.getID())
           {T.fire();}
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
