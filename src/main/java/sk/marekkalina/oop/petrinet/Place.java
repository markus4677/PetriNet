package sk.marekkalina.oop.petrinet;

public class Place extends PetriObject {


    private int x;
    private int y;

    private int tokens = 0;




    public Place(long ID, String name, int tokens) {
        super(name, ID);
        this.tokens = tokens;

    }


    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }

    public Place(String name, long ID) {
        super(name, ID);
    }




    public boolean test_tokens(int weight)
    {
        return (tokens>=weight);
    };

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }


    public void addTokens(int weight) {
        this.tokens += weight;
    }

    public void removeTokens(int weight) {
        this.tokens -= weight;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", tokens=" + tokens +
                '}';
    }
}

