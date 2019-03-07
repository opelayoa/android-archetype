package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "satusuario")
public class SatUsuario implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "nempleado")
    @SerializedName("nempleado")
    private int nempleado;
    @ColumnInfo(name = "ulogin")
    @SerializedName("ulogin")
    private String ulogin;
    @ColumnInfo(name = "unombre")
    @SerializedName("unombre")
    private String unombre;
    @ColumnInfo(name = "uapellidop")
    @SerializedName("uapellidop")
    private String uapellidop;
    @ColumnInfo(name = "uapellidom")
    @SerializedName("uapellidom")
    private String uapellidom;
    @ColumnInfo(name = "ptoclave")
    @SerializedName("ptoclave")
    private int ptoclave;
    @ColumnInfo(name = "uclavegrupo")
    @SerializedName("uclavegrupo")
    private String uclavegrupo;
    @ColumnInfo(name = "iddeptoalmacen")
    @SerializedName("iddeptoalmacen")
    private int iddeptoalmacen;

    public SatUsuario() {
    }

    public int getNempleado() {
        return this.nempleado;
    }

    public void setNempleado(int nempleado) {
        this.nempleado = nempleado;
    }

    public String getUlogin() {
        return this.ulogin;
    }

    public void setUlogin(String ulogin) {
        this.ulogin = ulogin;
    }

    public String getUnombre() {
        return this.unombre;
    }

    public void setUnombre(String unombre) {
        this.unombre = unombre;
    }

    public String getUapellidop() {
        return this.uapellidop;
    }

    public void setUapellidop(String uapellidop) {
        this.uapellidop = uapellidop;
    }

    public String getUapellidom() {
        return this.uapellidom;
    }

    public void setUapellidom(String uapellidom) {
        this.uapellidom = uapellidom;
    }

    public int getPtoclave() {
        return this.ptoclave;
    }

    public void setPtoclave(int ptoclave) {
        this.ptoclave = ptoclave;
    }

    public String getUclavegrupo() {
        return this.uclavegrupo;
    }

    public void setUclavegrupo(String uclavegrupo) {
        this.uclavegrupo = uclavegrupo;
    }

    public int getIddeptoalmacen() {
        return this.iddeptoalmacen;
    }

    public void setIddeptoalmacen(int iddeptoalmacen) {
        this.iddeptoalmacen = iddeptoalmacen;
    }

}
