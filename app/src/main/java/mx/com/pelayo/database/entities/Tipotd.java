package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tipotd")
public class Tipotd implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "nombre")
    @SerializedName("nombre")
    private String nombre;
    @ColumnInfo(name = "descripcion")
    @SerializedName("descripcion")
    private String descripcion;
    @ColumnInfo(name = "abreviatura")
    @SerializedName("abreviatura")
    private String abreviatura;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private boolean status;
    @ColumnInfo(name = "batch48h")
    @SerializedName("batch48h")
    private Byte batch48h;

    public Tipotd() {
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Byte getBatch48h() {
        return this.batch48h;
    }

    public void setBatch48h(Byte batch48h) {
        this.batch48h = batch48h;
    }

}
