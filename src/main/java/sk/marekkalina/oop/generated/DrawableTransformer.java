package sk.marekkalina.oop.generated;

import sk.marekkalina.oop.graphics.Drawable;
import sk.marekkalina.oop.graphics.Place2D;
import sk.marekkalina.oop.graphics.Transition2D;
import sk.marekkalina.oop.petrinet.PNet;
import java.util.LinkedList;
import java.util.List;

public class DrawableTransformer extends Transformer<List<Drawable>> {
    private PNet net;
    public DrawableTransformer(PNet net)
    {
        this.net = net;
    }
    @Override
    public List<Drawable> transform(Document document)
    {
        List<Drawable> drawables = new LinkedList<Drawable>();

        for (Place place:document.getPlace())
        {
            Place2D p = new Place2D(place.getX(),
                    place.getY(),
                    (sk.marekkalina.oop.petrinet.Place) net.getPlaces().stream().filter(place1 -> place1.getID()==place.getId())
            );
            drawables.add(p);
        }

        for (Transition transition: document.getTransition())
        {
            Transition2D t = new Transition2D(transition.getX(),
                    transition.getY(),
                    (sk.marekkalina.oop.petrinet.Transition) net.getTransitions().stream().filter(transition1 -> transition1.getID()==transition.getId())
            );
            drawables.add(t);
        }




        return null;
    }


}
