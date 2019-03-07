package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class AccesoId implements java.io.Serializable {

    @ColumnInfo(name = "node")
    @SerializedName("node")
    private String node;
    @ColumnInfo(name = "action")
    @SerializedName("action")
    private String action;
    @ColumnInfo(name = "perfil_id")
    @SerializedName("perfil-id")
    private int perfilId;

    public AccesoId() {
    }

    public AccesoId(String node, String action, int perfilId) {
        this.node = node;
        this.action = action;
        this.perfilId = perfilId;
    }

    public String getNode() {
        return this.node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPerfilId() {
        return this.perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof AccesoId))
            return false;
        AccesoId castOther = (AccesoId) other;
        return ((this.getNode() == castOther.getNode()) || (this.getNode() != null && castOther.getNode() != null
                && this.getNode().equals(castOther.getNode())))
                && ((this.getAction() == castOther.getAction()) || (this.getAction() != null
                && castOther.getAction() != null && this.getAction().equals(castOther.getAction())))
                && (this.getPerfilId() == castOther.getPerfilId());
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + (getNode() == null ? 0 : this.getNode().hashCode());
        result = 37 * result + (getAction() == null ? 0 : this.getAction().hashCode());
        result = 37 * result + this.getPerfilId();
        return result;
    }

}
