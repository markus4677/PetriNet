package sk.marekkalina.oop.graphics;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import sk.marekkalina.oop.petrinet.Transition;
import java.awt.Graphics2D;

import javax.xml.transform.Transformer;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
public class Transition2D extends Rectangle2D.Float implements Drawable{
    private Transition transition;

    public Transition2D(int x,int y,Transition transition) {
        super(x,y,40,40);
        this.transition = transition;
    }
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.draw(this);
    }
    public void onClick(MouseEvent e)
    {
        transition.fire();
    }


}
