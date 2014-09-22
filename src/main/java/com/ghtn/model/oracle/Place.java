package com.ghtn.model.oracle;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by lihe on 14/9/15.
 */
@Entity
public class Place {
    private int placeid;
    private String placenumber;
    private String placename;
    private Integer plid;
    private Integer pareasid;
    private String maindeptid;
    private BigInteger placestatus;

    @Id
    @Column(name = "PLACEID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    @Basic
    @Column(name = "PLACENUMBER", nullable = true, insertable = true, updatable = true, length = 40)
    public String getPlacenumber() {
        return placenumber;
    }

    public void setPlacenumber(String placenumber) {
        this.placenumber = placenumber;
    }

    @Basic
    @Column(name = "PLACENAME", nullable = true, insertable = true, updatable = true, length = 80)
    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    @Basic
    @Column(name = "PLID", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getPlid() {
        return plid;
    }

    public void setPlid(Integer plid) {
        this.plid = plid;
    }

    @Basic
    @Column(name = "PAREASID", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getPareasid() {
        return pareasid;
    }

    public void setPareasid(Integer pareasid) {
        this.pareasid = pareasid;
    }

    @Basic
    @Column(name = "MAINDEPTID", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMaindeptid() {
        return maindeptid;
    }

    public void setMaindeptid(String maindeptid) {
        this.maindeptid = maindeptid;
    }

    @Basic
    @Column(name = "PLACESTATUS", nullable = true, insertable = true, updatable = true, precision = 0)
    public BigInteger getPlacestatus() {
        return placestatus;
    }

    public void setPlacestatus(BigInteger placestatus) {
        this.placestatus = placestatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (placeid != place.placeid) return false;
        if (maindeptid != null ? !maindeptid.equals(place.maindeptid) : place.maindeptid != null) return false;
        if (pareasid != null ? !pareasid.equals(place.pareasid) : place.pareasid != null) return false;
        if (placename != null ? !placename.equals(place.placename) : place.placename != null) return false;
        if (placenumber != null ? !placenumber.equals(place.placenumber) : place.placenumber != null) return false;
        if (placestatus != null ? !placestatus.equals(place.placestatus) : place.placestatus != null) return false;
        if (plid != null ? !plid.equals(place.plid) : place.plid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = placeid;
        result = 31 * result + (placenumber != null ? placenumber.hashCode() : 0);
        result = 31 * result + (placename != null ? placename.hashCode() : 0);
        result = 31 * result + (plid != null ? plid.hashCode() : 0);
        result = 31 * result + (pareasid != null ? pareasid.hashCode() : 0);
        result = 31 * result + (maindeptid != null ? maindeptid.hashCode() : 0);
        result = 31 * result + (placestatus != null ? placestatus.hashCode() : 0);
        return result;
    }
}
