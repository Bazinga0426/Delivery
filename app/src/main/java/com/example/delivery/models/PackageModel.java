package com.example.delivery.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class PackageModel extends RealmObject {

    @PrimaryKey
    private String packageId;

    @Required
    private String site;

    @Required
    private String vendor;

    private UserModel driver;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public UserModel getDriver() {
        return driver;
    }

    public void setDriver(UserModel driver) {
        this.driver = driver;
    }
}
