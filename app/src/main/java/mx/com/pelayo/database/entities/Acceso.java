package mx.com.pelayo.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "acceso")
public class Acceso implements java.io.Serializable {

    @PrimaryKey
    @SerializedName("id")
    private AccesoId id;

    public Acceso() {
    }

    public Acceso(AccesoId id) {
        this.id = id;
    }

    public AccesoId getId() {
        return this.id;
    }

    public void setId(AccesoId id) {
        this.id = id;
    }

}
