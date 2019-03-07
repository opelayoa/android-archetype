package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "imp_cat_motivo")
public class ImpCatMotivo implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "descripcion")
    @SerializedName("descripcion")
    private String descripcion;
    @ColumnInfo(name = "descripcion_general")
    @SerializedName("descripcion-general")
    private String descripcionGeneral;
    @ColumnInfo(name = "solucionImp")
    @SerializedName("solucionImp")
    private String solucionImp;
    @ColumnInfo(name = "codigo")
    @SerializedName("codigo")
    private String codigo;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private byte status;

    public ImpCatMotivo() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionGeneral() {
        return this.descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public String getSolucionImp() {
        return this.solucionImp;
    }

    public void setSolucionImp(String solucionImp) {
        this.solucionImp = solucionImp;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public byte getStatus() {
        return this.status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

}
