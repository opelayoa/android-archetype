package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sintoma_diagnostico")
public class SintomaDiagnostico implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "diagnostico")
    @SerializedName("diagnostico")
    private String diagnostico;
    @ColumnInfo(name = "sub")
    @SerializedName("sub")
    private String sub;
    @ColumnInfo(name = "sintoma_id")
    @SerializedName("sintoma-id")
    private int sintomaId;
    @ColumnInfo(name = "diagnostico_id")
    @SerializedName("diagnostico-id")
    private int diagnosticoId;
    @ColumnInfo(name = "disminuir")
    @SerializedName("disminuir")
    private byte disminuir;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private boolean status;
    @ColumnInfo(name = "renueva")
    @SerializedName("renueva")
    private boolean renueva;

    public SintomaDiagnostico() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSub() {
        return this.sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getSintomaId() {
        return this.sintomaId;
    }

    public void setSintomaId(int sintomaId) {
        this.sintomaId = sintomaId;
    }

    public int getDiagnosticoId() {
        return this.diagnosticoId;
    }

    public void setDiagnosticoId(int diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }

    public byte getDisminuir() {
        return this.disminuir;
    }

    public void setDisminuir(byte disminuir) {
        this.disminuir = disminuir;
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
