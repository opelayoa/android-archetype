package mx.com.pelayo.database.entities.security;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "session")
public class Session implements java.io.Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "access_token")
    @SerializedName("access_token")
    private String accessToken;
    @ColumnInfo(name = "token_type")
    @SerializedName("token_type")
    private String tokenType;
    @ColumnInfo(name = "refresh_token")
    @SerializedName("refresh_token")
    private String refreshToken;
    @ColumnInfo(name = "expires_in")
    @SerializedName("expires_in")
    private String expiresIn;
    @ColumnInfo(name = "scope")
    @SerializedName("scope")
    private String scope;
    @ColumnInfo(name = "jti")
    @SerializedName("jti")
    private String jti;

    public Session() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}