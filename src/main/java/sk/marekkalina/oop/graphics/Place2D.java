package sk.marekkalina.oop.graphics;
import sk.marekkalina.oop.petrinet.Place;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;


public class Place2D extends Ellipse2D.Float implements Drawable<Place> {
    private Place place;

    @Override
    public Place getReference() {
        return this.place;
    }

    public Place getPlace() {
        return place;
    }

    public Place2D(int x , int y, Place place)
    {
        super(x,y,40,40);
        this.place = place;
    }


    @Override
    public void draw(Graphics2D graphics2D){
        graphics2D.draw(this);
        graphics2D.drawString(""+place.getTokens(),(int) getCenterX(),(int) getCenterY());
        //Dimension d = this.getPreferredSize();
        int fontSize = 20;



        graphics2D.setColor(Color.red);
        graphics2D.drawString(place.getName(),(int) getCenterX(),(int) getCenterY()+20);
        graphics2D.setColor(Color.black);


    };

    @Override
    public void onClick(MouseEvent eevee) {

        if (eevee.getButton() == MouseEvent.BUTTON1)
        {
            place.addTokens(1);
        }else if (eevee.getButton() == MouseEvent.BUTTON1)
            {
                place.removeTokens(1);
            }
    }

    public boolean contains(int x, int y)
    {
        return false;
    }



}
