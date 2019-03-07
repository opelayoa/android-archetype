package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "region")
public class Region {

    @PrimaryKey
    @ColumnInfo(name = "rclave")
    @SerializedName("rclave")
    private Integer rclave;
    @ColumnInfo(name = "rdesc")
    @SerializedName("rdesc")
    private String rdesc;
    @ColumnInfo(name = "useq")
    @SerializedName("useq")
    private Integer useq;

    public Integer getRclave() {
        return rclave;
    }

    public void setRclave(Integer rclave) {
        this.rclave = rclave;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public Integer getUseq() {
        return useq;
    }

    public void setUseq(Integer useq) {
        this.useq = useq;
    }

}
