package sk.marekkalina.oop.generated;



import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Importer {

    public Document importDocument(String path) throws JAXBException, FileNotFoundException
    {
        InputStream resource = ClassLoader.getSystemResourceAsStream("insurance.xml");
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return ((Document) unmarshaller.unmarshal(resource));
    }


}
