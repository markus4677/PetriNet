package sk.marekkalina.oop.graphics;

import sk.marekkalina.oop.petrinet.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;


public class Arcc2D extends Line2D.Float implements Drawable {

    private Arc arc;


    public Arcc2D(float x1, float y1, float x2, float y2) {
        super(x1, y1, x2, y2);

    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.draw(this);

    }

    public void onClick(MouseEvent e) {

    }

//    @Override
//    public double getX() {
//        return 0;
//    }
//
//    @Override
//    public double getY() {
//        return 0;
//    }

    @Override
    public Object getReference() {
        return null;
    }


}
