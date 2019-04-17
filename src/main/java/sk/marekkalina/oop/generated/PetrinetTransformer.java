package sk.marekkalina.oop.generated;
import sk.marekkalina.oop.petrinet.PNet;
//import sk.marekkalina.oop.generated.Transformer;

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
        }

        for (Transition transition : document.getTransition())
        {
            sk.marekkalina.oop.petrinet.Transition t = new sk.marekkalina.oop.petrinet.Transition(
              transition.getLabel(),
              transition.getId()
            );
        net.addTransition(t);

        }

        return net;

    }


}
