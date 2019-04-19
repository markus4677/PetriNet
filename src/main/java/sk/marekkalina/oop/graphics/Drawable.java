package sk.marekkalina.oop.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable<T> extends Shape {
    public void draw(Graphics2D graphics2D);

    public void onClick(MouseEvent e);

    //public double getX();
    //public double getY();
    public T getReference();
}
