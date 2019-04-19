package sk.marekkalina.oop.petrinet;

import java.util.List;

public class PetriObject {

    protected String name;
    protected long ID;

    public PetriObject() {

    }

    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }


    public PetriObject(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "PetriObject{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
