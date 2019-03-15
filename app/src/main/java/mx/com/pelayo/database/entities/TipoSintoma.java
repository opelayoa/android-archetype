package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tipo_sintoma", indices = {@Index(value = {"id", "status"})})
public class TipoSintoma implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "sintoma")
    @SerializedName("sintoma")
    private String sintoma;
    @ColumnInfo(name = "tipo_id")
    @SerializedName("tipo-id")
    private int tipoId;
    @ColumnInfo(name = "sintoma_id")
    @SerializedName("sintoma-id")
    private int sintomaId;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private boolean status;
    @ColumnInfo(name = "renueva")
    @SerializedName("renueva")
    private boolean renueva;

    public TipoSintoma() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSintoma() {
        return this.sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public int getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public int getSintomaId() {
        return this.sintomaId;
    }

    public void setSintomaId(int sintomaId) {
        this.sintomaId = sintomaId;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRenueva() {
        return this.renueva;
    }

    public void setRenueva(boolean renueva) {
        this.renueva = renueva;
    }

}
