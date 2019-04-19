
package sk.marekkalina.oop.generated;

import com.sun.deploy.uitoolkit.impl.text.TextPluginUIFactory;

import java.util.ArrayList;
import java.util.List;import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}transition" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}place" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{}arc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transition",
    "place",
    "arc"
})
@XmlRootElement(name = "document")
public class Document {

    @XmlElement(required = true)
    protected List<Transition> transition;
    protected List<Place> place;
    protected List<Arc> arc;






    public Transition docgetTransitionByID(long ID)
    {

        for (Transition tt:transition)
        {
            if(tt.getId()==ID) return tt;
            else  continue;
        }
        return transition.get(1);
    }



    public Place docgetPlaceByID(long ID)
    {

        for (Place pp:place)
        {
            if(pp.getId()==ID) return pp;

        }
        return place.get(1);
    }

//
//
//
    public List<Transition> getTransition() {
        if (transition == null) {
            transition = new ArrayList<>();
        }
        return this.transition;
    }




    public List<Place> getPlace() {
        if (place == null) {
            place = new ArrayList<>();
        }
        return this.place;
    }



    public List<Arc> getArc() {
        if (arc == null) {
            arc = new ArrayList<>();
        }
        return this.arc;
    }

}
