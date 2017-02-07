package Default;

import java.util.HashSet;
import java.util.Set;

public class MySet {
    private int ID;
    public Set<Integer> connections;

    public MySet(int ID) {
        setID(ID);
        connections = new HashSet<>();
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public boolean isConnectionExists(int ID) {
        if (connections.contains(ID))  // FIXME: 07.02.2017 may fail bcoz of checking for Object, not for Integer
            return true;
        else
            return false;
    }

    public void addConnection(int ID) {
        connections.add(ID);
    }
}
