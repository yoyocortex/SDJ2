package Kingdom.TreasureRoom;

import Kingdom.Catalogue;
import Kingdom.Valuable.Valuable;

import java.util.ArrayList;
import java.util.List;

public class TreasureRoom implements TreasureRoomDoor {
    private List<Valuable> gems;

    public TreasureRoom() {
        gems = new ArrayList<>();
    }

    // access methods

    public synchronized void acquireReadAccess(String actorName) {
        // note in the catalogue a person entered
        Catalogue.getCatalogue().addToQueue("Acquire read access > " + actorName);
        System.out.println("Acquire read access > " + actorName);
    }

    public synchronized void acquireWriteAccess(String actorName) {
        // note in the catalogue a person entered
        Catalogue.getCatalogue().addToQueue("Acquire write access > " + actorName);
        System.out.println("Acquire write access > " + actorName);
    }

    public synchronized void releaseReadAccess(String actorName) {
        // note in the catalogue a person left
        Catalogue.getCatalogue().addToQueue("Release read access > " + actorName);
        System.out.println("Release read access > " + actorName);
    }

    public synchronized void releaseWriteAccess(String actorName) {
        // note in the catalogue a person left
        Catalogue.getCatalogue().addToQueue("Release write access > " + actorName);
        System.out.println("Release write access > " + actorName);
    }

    // interact methods

    public Valuable retrieveValuable() {
        Valuable v = null;
        if (gems.size() > 0) {
            v = gems.remove(0);
        }
        return v;
    }

    public void addValuable(Valuable v) {
        Catalogue.getCatalogue().addToQueue("Added " + v.getName() + " to the treasure room"); //, amount or gems in the treasure room; " + gems.size());
        System.out.println("Added " + v.getName() + " to the treasure room");
        //System.out.println("Added " + v.getName() + " to the treasure room, amount or gems in the treasure room; " + gems.size());
        gems.add(v);
    }

    @Override
    public List<Valuable> lookAtAllGems() {
        Catalogue.getCatalogue().addToQueue("Total count of gems is " + gems.size());
        System.out.println("Total count of gems is " + gems.size());
        return new ArrayList<Valuable>(gems);
    }
}
