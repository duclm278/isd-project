package org.openjfx.hellofx.models.bike7;

import java.util.HashMap;

public class Bike {
    public HashMap<Integer, HashMap<String, Object>> dictionary;

    public Bike() {
        this.getAllBike();
    }

    public HashMap<Integer, HashMap<String, Object>> getAllBike() {
        HashMap<Integer, HashMap<String, Object>> dict = new HashMap<>();

        HashMap<String, Object> item1 = new HashMap<>();
        item1.put("code", "0#96AB2");
        item1.put("pin", "40%");
        item1.put("type", 2);
        dict.put(1, item1);

        HashMap<String, Object> item2 = new HashMap<>();
        item2.put("code", "X0S@aaa");
        item2.put("pin", "50%");
        item2.put("type", 1);
        dict.put(2, item2);

        HashMap<String, Object> item3 = new HashMap<>();
        item3.put("code", "KM&BV0");
        item3.put("pin", "70%");
        item3.put("type", 3);
        dict.put(3, item3);

        this.dictionary = dict;
        return this.dictionary;

    }

    public HashMap<String, Object> getBikeByBarCode(HashMap<Integer, HashMap<String, Object>> dictionary, String code) {
        for (HashMap<String, Object> item : dictionary.values()) {
            if (item.containsKey("code") && item.get("code").equals(code)) {
                return item;
            }
        }
        return null;
    }
}
