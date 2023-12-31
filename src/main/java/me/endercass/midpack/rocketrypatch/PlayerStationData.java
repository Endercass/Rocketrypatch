package me.endercass.midpack.rocketrypatch;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class PlayerStationData {
    private static final HashMap<UUID, Integer[]> modHashMap = new HashMap<>();

    public static HashMap<UUID, Integer[]> getModHashMap() {
        return modHashMap;
    }

    public static void addStationForPlayer(UUID key, Integer value) {
        System.out.println(value);
        Integer[] old;

        if (modHashMap.containsKey(key)) {
            old = modHashMap.get(key);
        } else {
            old = new Integer[0];
        }

        if (!Arrays.asList(old).contains(value)) {
            Integer[] newarray = new Integer[old.length + 1];
            System.arraycopy(old, 0, newarray, 0, old.length);
            newarray[old.length] = value;
            modHashMap.put(key, newarray);
        }
    }
}
