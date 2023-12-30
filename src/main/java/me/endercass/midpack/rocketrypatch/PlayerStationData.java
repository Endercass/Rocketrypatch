package me.endercass.midpack.rocketrypatch;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class PlayerStationData {
    private static final HashMap<UUID, Integer[]> modHashMap = new HashMap<>();

    public static HashMap<UUID, Integer[]> getModHashMap() {
        return modHashMap;
    }

    public static void addToModHashMap(UUID key, Integer[] value) {
        System.out.println(Arrays.toString(value));
        modHashMap.put(key, value);
    }
}
