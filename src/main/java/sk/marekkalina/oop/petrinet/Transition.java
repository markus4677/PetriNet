package sk.marekkalina.oop.petrinet;

import java.util.ArrayList;
import java.util.List;

public class Transition extends PetriObject {


    List<Arc> input_arcs = new ArrayList<Arc>();
    List<Arc> output_arcs = new ArrayList<Arc>();
    List<ResetArc> reset_arcs = new ArrayList<ResetArc>();



    public boolean firable() {
        boolean firable = true;


        firable = ! this.isNotConnected();

        for (Arc arc : input_arcs) {
            firable = firable & arc.fire_test();
            firable = (arc.getWeight()<=(arc.getSpot().getTokens()));
        }
        for (Arc arc : output_arcs) {
            firable = firable & arc.fire_test();
        }

        return firable;


    }


    public List<Arc> getInputsArcs()
    {
        if(input_arcs==null) input_arcs = new ArrayList<>();
        return this.input_arcs;
    }
    public List<Arc> getOutptArcs()
    {
        if(output_arcs==null) input_arcs = new ArrayList<>();
        return this.output_arcs;
    }






    public void fire() {
        boolean r = firable();
        if (r){
                    for (Arc arc1 : input_arcs) {
                        if(arc1.getSpot().getTokens()>0)
                        arc1.fire();
                        System.out.println("Input arc fired: "+arc1.toString());
                    }
                    for (Arc arc : output_arcs) {

                        arc.fire();
                        System.out.println("Output arc fired"+arc.toString());
                    }
                    for (ResetArc reset_arc : reset_arcs)
                    {
                        reset_arc.fire();
                    }
        }
        else System.out.println("Transition cannot be fired");
    }

    public void addInputArcs(Arc arc) {
        this.input_arcs.add(arc);
    };

    public void addOutputArcs(Arc arc) {
        this.output_arcs.add(arc);
    }
    public void addResetArc(ResetArc reset_arc)
    {
        this.reset_arcs.add(reset_arc);
    }


    public Transition(String name, long ID) {
        super(name, ID);
        this.ID=ID;
        this.name=name;
    }



    public List<Arc> getInput_arcs() {
        return input_arcs;
    }

    public List<Arc> getOutput_arcs() {
        return output_arcs;
    }

    public List<ResetArc> getReset_arcs() {
        return reset_arcs;
    }



    @Override
    public String toString() {
        return "Transition{" +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }

    protected boolean isNotConnected() {
        return input_arcs.isEmpty() && output_arcs.isEmpty();
    }

//    public boolean isResetNotConnected() {
//        return reset_arcs.isEmpty();
//    }


}
