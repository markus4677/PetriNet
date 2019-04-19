package sk.marekkalina.oop.graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

public class MyCanvas extends Canvas implements MouseListener {

    private List<Drawable> elementList = new LinkedList<Drawable>();

    public void setElementList(List<Drawable> elementList) {
        this.elementList = elementList;
    }

    //@Override
    public void mouseClicked(MouseEvent e) {
        for (Drawable element: elementList){
            if (element.contains(e.getX(), e.getY())){
                element.onClick(e);
                this.repaint();
                break;
            }
        }
    }

    //@Override
    public void mousePressed(MouseEvent e) {
    }

    //@Override
    public void mouseReleased(MouseEvent e) {
    }

    //@Override
    public void mouseEntered(MouseEvent e) {
    }

    //@Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void paint(Graphics graphics) {

        Graphics2D g2 = (Graphics2D)graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (Drawable element : elementList) element.draw(g2);
    }
}
