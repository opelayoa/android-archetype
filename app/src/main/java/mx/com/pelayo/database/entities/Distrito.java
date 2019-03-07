package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "distrito")
public class Distrito implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "dclave")
    @SerializedName("dclave")
    private int dclave;
    @ColumnInfo(name = "ddesc")
    @SerializedName("ddesc")
    private String ddesc;
    @ColumnInfo(name = "zona_id")
    @SerializedName("zona-id")
    private int zonaId;
    @ColumnInfo(name = "useq")
    @SerializedName("useq")
    private int useq;

    public Distrito() {
    }

    public int getDclave() {
        return this.dclave;
    }

    public void setDclave(int dclave) {
        this.dclave = dclave;
    }

    public String getDdesc() {
        return this.ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

    public int getZonaId() {
        return this.zonaId;
    }

    public void setZonaId(int zonaId) {
        this.zonaId = zonaId;
    }

    public int getUseq() {
        return this.useq;
    }

    public void setUseq(int useq) {
        this.useq = useq;
    }
}