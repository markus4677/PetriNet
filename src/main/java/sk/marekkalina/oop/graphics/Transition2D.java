package sk.marekkalina.oop.graphics;

import sk.marekkalina.oop.petrinet.Transition;

import java.awt.*;

import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;

public class Transition2D extends Rectangle2D.Float implements Drawable<Transition> {
    private Transition transition;

    public Transition2D(int x, int y, Transition transition) {
        super(x, y, 40, 40);
        this.transition = transition;
    }


    @Override
    public Transition getReference() {
        return this.transition;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.draw(this);
        graphics2D.drawString(transition.getName(), (int) getCenterX() - 50, (int) getCenterY() + 40);

        if (transition.firable()) {


            graphics2D.setColor(Color.green);
            graphics2D.fillRect((int) x + 1, (int) y + 1, 39, 39);
            graphics2D.setColor(Color.black);
        } else {
            graphics2D.setColor(Color.white);
            graphics2D.fillRect((int) x + 1, (int) y + 1, 39, 39);
            graphics2D.setColor(Color.black);
        }
    }


    @Override
    public void onClick(MouseEvent e) {
        System.out.println(transition.toString());
        transition.fire();
    }


}
