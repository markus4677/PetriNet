package sk.marekkalina.oop.graphics;
import sk.marekkalina.oop.petrinet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Drawable {
    private Place place;


    public Place2D(int x ,int y,Place place)
    {
        super(x,y,40,40);
        this.place = place;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.draw(this);
        graphics2D.drawString(""+place.getTokens(),(int) getCenterX(),(int) getCenterY());
        graphics2D.drawString(place.getName(),(int) getCenterX(),(int) getCenterY()+20);
    };


    public void onClick(MouseEvent eevee) {

        if (eevee.getButton() == MouseEvent.BUTTON1)
        {
            //do some shit
        }else if (eevee.getButton() == MouseEvent.BUTTON1)
            {
                //DO SOME OTHER SHIT
            }
    }

    public boolean contains(int x, int y)
    {
        return false;
    }



}
