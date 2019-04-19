package sk.marekkalina.oop.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.Button;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
public class Buttonn  extends java.awt.Button {


    File file=new File("~");
    Desktop desktop = Desktop.getDesktop();

    //@Override
    public void actionPerformed(ActionEvent aa) {
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
