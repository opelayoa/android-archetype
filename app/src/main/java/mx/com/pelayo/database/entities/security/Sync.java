package mx.com.pelayo.database.entities.security;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "synchronization")
public class Sync {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private Integer userId;
    @ColumnInfo(name = "date")
    private Date date;
    @ColumnInfo(name = "status")
    private Integer status;

    public Sync() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sync{" +
                "userId=" + userId +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
