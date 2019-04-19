package sk.marekkalina.oop.generated;
import sk.marekkalina.oop.petrinet.PNet;
import sk.marekkalina.oop.generated.Document;
import sk.marekkalina.oop.generated.Transformer;
import java.util.ArrayList;
import java.util.List;
import sk.marekkalina.oop.generated.Transition;

import static com.sun.deploy.cache.Cache.exists;

public class PetrinetTransformer extends Transformer<PNet> {


    public PNet transform(Document document)
    {
        PNet net = new PNet();

        for (Place place:document.getPlace())
        {
            sk.marekkalina.oop.petrinet.Place place1 = new sk.marekkalina.oop.petrinet.Place(
                    place.getId(),
                    place.getLabel(),
                    place.getTokens()
            );
            net.addPlace(place1);
            //System.out.println(place1.getID());
        }

        for (Transition transition : document.getTransition())
        {
            sk.marekkalina.oop.petrinet.Transition t = new sk.marekkalina.oop.petrinet.Transition(
              transition.getLabel(),
              transition.getId()
            );
        net.addTransition(t);

        }




        for (Arc arc : document.getArc()) {

            boolean state = false;
            for (Place place1 : document.getPlace())
            {
                if(place1.getId()==arc.getDestinationId())
                { state=true;}
                else{ continue;}
            };


            if(state)
            {
                sk.marekkalina.oop.petrinet.Arc a = new sk.marekkalina.oop.petrinet.Arc(
                        net.getTransitionByID(arc.getDestinationId()),
                        net.getPlaceByID(arc.getSourceId()));

                //System.out.println(net.getTransitionByID(arc.getSourceId()).getID()+"||---> Place"+net.getPlaceByID(arc.getDestinationId()).getID());
                a.setWeight(arc.getMultiplicity());


            }
                    else
            {
                sk.marekkalina.oop.petrinet.Arc a = new sk.marekkalina.oop.petrinet.Arc(
                        net.getPlaceByID(arc.getSourceId()),
                        net.getTransitionByID(arc.getDestinationId()));
                //System.out.println(net.getPlaceByID(arc.getSourceId()).getID()+" Place--->||"+net.getTransitionByID(arc.getDestinationId()).getID());
                a.setWeight(arc.getMultiplicity());




            }


        }

        for (sk.marekkalina.oop.petrinet.Transition ttt : net.getTransitions())

            for(sk.marekkalina.oop.petrinet.Arc arch:ttt.getInput_arcs())
            {
                System.out.println(arch.toString());
            }


        return net;

    }


}
