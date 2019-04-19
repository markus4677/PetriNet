package sk.marekkalina.oop.generated;

import sk.marekkalina.oop.graphics.Arcc2D;
import sk.marekkalina.oop.graphics.Drawable;
import sk.marekkalina.oop.graphics.Place2D;
import sk.marekkalina.oop.graphics.Transition2D;
import sk.marekkalina.oop.petrinet.PNet;
import sk.marekkalina.oop.graphics.MyFrame;

import java.util.LinkedList;
import java.util.List;

//import sk.marekkalina.oop.petrinet.Arc;

public class DrawableTransformer extends Transformer<List<Drawable>> {

    private PNet net;

    public DrawableTransformer(PNet net) {
        this.net = net;
    }

    @Override
    public List<Drawable> transform(Document document) {
        List<Drawable> drawablesList = new LinkedList<>();


        for (Arc arc : document.getArc()) {


            int x1 = (document.docgetPlaceByID(arc.getSourceId())).getX();
            int y1 = (document.docgetPlaceByID(arc.getSourceId())).getY();
            int x2 = (document.docgetTransitionByID(arc.getDestinationId())).getX();
            int y2 = (document.docgetTransitionByID(arc.getDestinationId())).getY();

            Arcc2D A = new Arcc2D((float) x1 + 20, (float) y1 + 20, (float) x2 + 20, (float) y2 + 20);

            drawablesList.add(A);

        }
        ;

        for (Arc arc : document.getArc()) {


            int x1 = (document.docgetPlaceByID(arc.getDestinationId())).getX();
            int y1 = (document.docgetPlaceByID(arc.getDestinationId())).getY();
            int x2 = (document.docgetTransitionByID(arc.getSourceId())).getX();
            int y2 = (document.docgetTransitionByID(arc.getSourceId())).getY();

            Arcc2D A = new Arcc2D((float) x1 + 20, (float) y1 + 20, (float) x2 + 20, (float) y2 + 20);

            drawablesList.add(A);

        }
        ;


        for (Place place : document.getPlace()) {
            Place2D p = new Place2D(
                    place.getX(),
                    place.getY(),
                    (sk.marekkalina.oop.petrinet.Place) net.getPlaceByID(place.getId())
            );
            drawablesList.add(p);


        }


        for (Transition transition2 : document.getTransition()) {
            Transition2D t = new Transition2D(transition2.getX(),
                    transition2.getY(),
                    (sk.marekkalina.oop.petrinet.Transition) net.getTransitionByID(transition2.getId())
            );
            drawablesList.add(t);
        }


        return drawablesList;
    }


}
