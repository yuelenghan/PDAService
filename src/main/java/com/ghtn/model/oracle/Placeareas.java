package com.ghtn.model.oracle;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lihe on 14/9/15.
 */
@Entity
public class Placeareas {
    private int pareasid;
    private String pareasname;
    private String status;
    private String maindeptid;

    @Id
    @Column(name = "PAREASID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPareasid() {
        return pareasid;
    }

    public void setPareasid(int pareasid) {
        this.pareasid = pareasid;
    }

    @Basic
    @Column(name = "PAREASNAME", nullable = true, insertable = true, updatable = true)
    public String getPareasname() {
        return pareasname;
    }

    public void setPareasname(String pareasname) {
        this.pareasname = pareasname;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, insertable = true, updatable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "MAINDEPTID", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMaindeptid() {
        return maindeptid;
    }

    public void setMaindeptid(String maindeptid) {
        this.maindeptid = maindeptid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Placeareas that = (Placeareas) o;

        if (pareasid != that.pareasid) return false;
        if (maindeptid != null ? !maindeptid.equals(that.maindeptid) : that.maindeptid != null) return false;
        if (pareasname != null ? !pareasname.equals(that.pareasname) : that.pareasname != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pareasid;
        result = 31 * result + (pareasname != null ? pareasname.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (maindeptid != null ? maindeptid.hashCode() : 0);
        return result;
    }
}
