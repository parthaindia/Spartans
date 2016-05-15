package com.spartans.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spartans.dto.Location;
import com.spartans.dto.OfficialInfo;
import com.spartans.dto.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {

    public String createOder(Order neworder) throws Exception {
        if (neworder == null) {
            return "Sorry no data received";
        }
        neworder.setCreatedate(System.currentTimeMillis() + "");
        neworder.setUpdatedate(System.currentTimeMillis() + "");
        neworder.setStatus("active");
        return DBManager.getDB().addDefault("Order", new Gson().toJson(neworder));
    }

    public String getAllOrders(Location nearBy) throws Exception {
        if (nearBy == null) {
            return null;
        }
        return DBManager.getDB().getAll("Order");
    }

    public List<Order> getOrdersFromPool() throws Exception {
        String orderJson = DBManager.getDB().getAll("Order");
        List<Order> orderList = new Gson().fromJson(orderJson, new TypeToken<List<Order>>() {
        }.getType());
        return orderList;
    }

    public List<Order> getAllassignedOrder() throws Exception {
        Map conditionMap = new HashMap();
        conditionMap.put("status", "assigned");
        String orderJson = DBManager.getDB().getByCondition("Order", conditionMap);
        List<Order> orderList = new Gson().fromJson(orderJson, new TypeToken<List<Order>>() {
        }.getType());
        return orderList;
    }

    public List<Order> getAllcompletedOrder() throws Exception {
        Map conditionMap = new HashMap();
        conditionMap.put("status", "completed");
        String orderJson = DBManager.getDB().getByCondition("Order", conditionMap);
        List<Order> orderList = new Gson().fromJson(orderJson, new TypeToken<List<Order>>() {
        }.getType());
        return orderList;
    }

    public List<Order> getAllBasedOnCondtition(Map param) throws Exception {
        if (param == null) {
            return null;
        }
        String orderJson = DBManager.getDB().getByCondition("Order", param);
        List<Order> orderList = new Gson().fromJson(orderJson, new TypeToken<List<Order>>() {
        }.getType());
        return orderList;
    }

    public boolean updateOrder(String Id, Map inputMap) throws Exception {
        if (Id == null || inputMap == null) {
            return false;
        }
        String json = DBManager.getDB().getByKey("Order", Id);
        List<Map> olderMap = new Gson().fromJson(json, new TypeToken<List<Map>>() {
        }.getType());
        Map existingMap = olderMap.get(0);
        existingMap.putAll(inputMap);
        return DBManager.getDB().modify("Order", new Gson().toJson(existingMap), Id);
    }

    public String getOrderIdBased(String Id) throws Exception {
        if (Id == null) {
            return "no data received";
        }
        return DBManager.getDB().getByKey("Order", Id);
    }

    public boolean acceptOrder(String Id) throws Exception {
        Map conditionMap = new HashMap();
        conditionMap.put("status", "accepted");
        return updateOrder(Id, conditionMap);
    }

    public static void main(String arg[]) throws Exception {
        Order or = new Order();
        Location locationFrom = new Location();
        locationFrom.setLatitude("12.9796° N");
        locationFrom.setLongitude("77.5907° E");
        Location locationTo = new Location();
        locationTo.setLatitude("15.8872° N");
        locationTo.setLongitude("75.7047° E");

        OfficialInfo merchantInfo = new OfficialInfo();
        merchantInfo.setAddress("Bangalore Electronic city");
        merchantInfo.setCity("Bangalore");
        merchantInfo.setName("Ammi Biryani");
        merchantInfo.setVarified(true);

        or.setLocationFrom(locationFrom);
        or.setLocationTo(locationTo);
        or.setMerchantInfo(merchantInfo);
        or.setName("FirstOrder");
        String id = DBManager.getDB().addDefault("Order", new Gson().toJson(or));
        System.out.println(id);
    }

}
