
package com.spartans.dto;

public class DelivaryPerson {
    private Object _id;
    private String name;
    private String status;
    private String createdate;
    private String updatedate;
    private Location serviceLocation;
    private Location liveLocation;
    private Location locationToOperate;

    public Object getId() {
        return _id;
    }

    public void setId(Object _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public Location getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(Location serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public Location getLiveLocation() {
        return liveLocation;
    }

    public void setLiveLocation(Location liveLocation) {
        this.liveLocation = liveLocation;
    }

    public Location getLocationToOperate() {
        return locationToOperate;
    }

    public void setLocationToOperate(Location locationToOperate) {
        this.locationToOperate = locationToOperate;
    }
    
}
