package fr.samlegamer.addonslib.data;

public class BlockId {
    private final String id;
    private final String reflectedLocation;

    public BlockId(String id, String reflectedLocation) {
        this.id = id;
        this.reflectedLocation = reflectedLocation;
    }

    public String id() {
        return id;
    }

    public String reflectedLocation() {
        return reflectedLocation;
    }
}