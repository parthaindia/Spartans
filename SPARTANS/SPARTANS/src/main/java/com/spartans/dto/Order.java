package com.spartans.dto;

public class Order {

    private Object _id;
    private String name;
    private String status;
    private String createdate;
    private String updatedate;
    private Location locationFrom;
    private Location locationTo;
    private String expecedTime;
    private String timeTaken;
    private OfficialInfo merchantInfo;

    public OfficialInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(OfficialInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getExpecedTime() {
        return expecedTime;
    }

    public void setExpecedTime(String expecedTime) {
        this.expecedTime = expecedTime;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }



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

    public Location getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(Location locationFrom) {
        this.locationFrom = locationFrom;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(Location locationTo) {
        this.locationTo = locationTo;
    }

}
