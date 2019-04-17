package sk.marekkalina.oop.graphics;

import sk.marekkalina.oop.generated.*;
import sk.marekkalina.oop.petrinet.PNet;
import sun.awt.image.PNGImageDecoder;

import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class MyFrame extends Frame implements ActionListener {


    private MyCanvas canvas;

    public MyFrame() throws  HeadlessException {
        super("Petrinere editor");
        setVisible(true);
        setSize(640,480);
       //addWindowListener((WindowAdapter) win);
        canvas = new MyCanvas();
    };



    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            FileDialog dialog = new FileDialog(this,"Otvor",FileDialog.LOAD);
            String path = dialog.getDirectory()+dialog.getFile();
            Importer importer = new Importer();
            Document document = importer.importDocument(path);

            PetrinetTransformer netTransformer = new PetrinetTransformer();
            PNet net = netTransformer.transform(document);

            DrawableTransformer drawableTransformer = new DrawableTransformer();
            List<Drawable> drawableList = drawableTransformer.transform(document);




        }
        catch (JAXBException excep)
        {
            excep.printStackTrace();
        }
        catch (FileNotFoundException excep)
        {
            excep.printStackTrace();
        }




    };

}
