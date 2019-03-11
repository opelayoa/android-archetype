package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "icon_entity")
public class IconEntity implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    @ColumnInfo(name = "icon_name")
    @SerializedName("icon-name")
    private String iconName;
    @ColumnInfo(name = "entity_type")
    @SerializedName("entity-type")
    private String entityType;
    @ColumnInfo(name = "entity_id")
    @SerializedName("entity-id")
    private int entityId;

    public IconEntity() {
    }

    public IconEntity(int id, String iconName, String entityType, int entityId) {
        super();
        this.id = id;
        this.iconName = iconName;
        this.entityType = entityType;
        this.entityId = entityId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }


    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

}
