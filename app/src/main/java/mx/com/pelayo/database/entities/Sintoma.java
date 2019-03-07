package mx.com.pelayo.database.entities;
// Generated 6/03/2019 08:17:38 AM by Hibernate Tools 4.3.5.Final

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sintoma")
public class Sintoma implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "nombre")
    @SerializedName("nombre")
    private String nombre;
    @ColumnInfo(name = "sub")
    @SerializedName("sub")
    private String sub;
    @ColumnInfo(name = "descripcion")
    @SerializedName("descripcion")
    private String descripcion;
    @ColumnInfo(name = "fallo")
    @SerializedName("fallo")
    private byte fallo;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private String status;

    public Sintoma() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSub() {
        return this.sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte getFallo() {
        return this.fallo;
    }

    public void setFallo(byte fallo) {
        this.fallo = fallo;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
