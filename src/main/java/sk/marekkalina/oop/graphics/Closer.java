package sk.marekkalina.oop.graphics;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Closer extends WindowAdapter {
    public void windowClosing (WindowEvent e) {
        System.exit(0);
    }
}
