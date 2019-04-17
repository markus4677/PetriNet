package sk.marekkalina.oop.graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class MyCanvas extends Canvas implements MouseListener {

    private List<Drawable> elementList = new LinkedList<Drawable>();

    public void paint(Graphics2D g)
    {
        for (Drawable el:elementList)
        {
            el.draw((Graphics2D) g);
        }
    }

    public void mouseClicked(MouseEvent e)
    {
        for(Drawable el :elementList)
        {
            if(el.contains(e.getX(),getY()))
            {
                el.onClick(e);
            }
        }
    }
    public void mousePressed(MouseEvent e)
    {
    }




    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }



}
