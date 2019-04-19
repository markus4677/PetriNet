package sk.marekkalina.oop.graphics;

import sk.marekkalina.oop.generated.Document;
import sk.marekkalina.oop.generated.DrawableTransformer;
import sk.marekkalina.oop.generated.Importer;
import sk.marekkalina.oop.generated.PetrinetTransformer;
import sk.marekkalina.oop.petrinet.PNet;


import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.io.FileNotFoundException;
import java.util.List;


public class MyFrame extends Frame implements ActionListener {


    private MyCanvas canvas;

    public MyFrame() throws HeadlessException {


        super("Petrinet");
        setVisible(true);
        setSize(1600, 800);
        addWindowListener(new Closer()); //not by Chainsmokers

        //but.setForeground(Color.yellow);


        this.canvas = new MyCanvas();
        this.add("Center", canvas);

        canvas.setBackground(Color.WHITE);
        MenuBar menuBar = new MenuBar();


        Menu menu1 = new Menu("File");
        MenuItem mItem1 = new MenuItem("Open...");
        mItem1.setActionCommand("New");
        menu1.add(mItem1);
        menuBar.add(menu1);
        setMenuBar(menuBar);


        mItem1.addActionListener(this);
        canvas.addMouseListener(canvas);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            try {

                FileDialog fileDialog = new FileDialog(this, "Otvor", FileDialog.LOAD);
                fileDialog.setDirectory("./src/main/resources");
                fileDialog.setVisible(true);
                fileDialog.setFile("insurance.xml");
                String path = fileDialog.getDirectory() + fileDialog.getFile();


                Importer importer = new Importer();
                Document document = importer.importDocument(path);

                PetrinetTransformer PetrinetTransformer = new PetrinetTransformer();
                PNet petriFlow = PetrinetTransformer.transform(document);

                DrawableTransformer drawableTransformer = new DrawableTransformer(petriFlow);
                List<Drawable> drawableList = drawableTransformer.transform(document);

                canvas.setElementList(drawableList);
                canvas.repaint();
            } catch (FileNotFoundException | JAXBException e1) {
                e1.printStackTrace();
                System.out.println(e1.getMessage());
            }
        }
    }
}




