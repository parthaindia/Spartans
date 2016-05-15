package com.spartans.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spartans.dto.DelivaryPerson;
import java.util.List;
import java.util.Map;

public class DelivaryManager {

    public String createDelivaryPerson(String json) throws Exception {
        if (json == null) {
            return "no data found";
        }
        return DBManager.getDB().addDefault("deliverperson", json);

    }

    public boolean updatedelivaryPerson(String Id, Map<String, String> inputMap) throws Exception {
        if (Id == null || inputMap == null) {
            return false;
        }
        String json = DBManager.getDB().getByKey("deliverperson", Id);
        List<Map> olderMap = new Gson().fromJson(json, new TypeToken<List<Map>>() {
        }.getType());
        Map existingMap = olderMap.get(0);
        existingMap.putAll(inputMap);
        return DBManager.getDB().modify("deliverperson", new Gson().toJson(existingMap), Id);
    }

    public String getAllDelivaryPerson() throws Exception {
        return DBManager.getDB().getAll("deliverperson");
    }

    public String getDelivaryPersonIdBased(String Id) throws Exception {
        if (Id == null) {
            return "no data received";
        }
        return DBManager.getDB().getByKey("deliverperson", Id);
    }
}
