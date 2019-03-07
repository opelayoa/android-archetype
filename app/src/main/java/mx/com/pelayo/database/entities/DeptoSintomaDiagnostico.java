package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "depto_sintoma_diagnostico")
public class DeptoSintomaDiagnostico implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "depto_id")
    @SerializedName("depto-id")
    private int deptoId;
    @ColumnInfo(name = "sd_id")
    @SerializedName("sd-id")
    private int sdId;
    @ColumnInfo(name = "userreg")
    @SerializedName("userreg")
    private int userreg;
    @ColumnInfo(name = "fechareg")
    @SerializedName("fechareg")
    private Date fechareg;
    @ColumnInfo(name = "userdel")
    @SerializedName("userdel")
    private int userdel;
    @ColumnInfo(name = "fechadel")
    @SerializedName("fechadel")
    private Date fechadel;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private boolean status;

    public DeptoSintomaDiagnostico() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeptoId() {
        return this.deptoId;
    }

    public void setDeptoId(int deptoId) {
        this.deptoId = deptoId;
    }

    public int getSdId() {
        return this.sdId;
    }

    public void setSdId(int sdId) {
        this.sdId = sdId;
    }

    public int getUserreg() {
        return this.userreg;
    }

    public void setUserreg(int userreg) {
        this.userreg = userreg;
    }

    public Date getFechareg() {
        return this.fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public int getUserdel() {
        return this.userdel;
    }

    public void setUserdel(int userdel) {
        this.userdel = userdel;
    }

    public Date getFechadel() {
        return this.fechadel;
    }

    public void setFechadel(Date fechadel) {
        this.fechadel = fechadel;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
