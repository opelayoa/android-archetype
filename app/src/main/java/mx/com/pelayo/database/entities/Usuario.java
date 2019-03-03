package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import mx.com.pelayo.database.DateTypeConverter;

@Entity(tableName = "usuario")
public class Usuario {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    @ColumnInfo(name = "apellido")
    @SerializedName("apellido")
    private String apellido;
    @ColumnInfo(name = "nombre")
    @SerializedName("nombre")
    private String nombre;
    @ColumnInfo(name = "login")
    @SerializedName("login")
    private String login;
    @ColumnInfo(name = "password")
    @SerializedName("password")
    private String password;
    @ColumnInfo(name = "email")
    @SerializedName("email")
    private String email;
    @ColumnInfo(name = "celular")
    @SerializedName("celular")
    private String celular;
    @ColumnInfo(name = "alias")
    @SerializedName("alias")
    private String alias;
    @ColumnInfo(name = "departamento_id")
    @SerializedName("departamento-id")
    private int departamentoId;
    @ColumnInfo(name = "sucursal_id")
    @SerializedName("sucursal-id")
    private int sucursalId;
    @ColumnInfo(name = "perfil_id")
    @SerializedName("perfil-id")
    private int perfilId;
    @ColumnInfo(name = "envio_correo")
    @SerializedName("envio-correo")
    private int envioCorreo;
    @ColumnInfo(name = "user_gasto")
    @SerializedName("user-gasto")
    private int userGasto;
    @ColumnInfo(name = "user_create")
    @SerializedName("user-create")
    private int userCreate;
    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "date_create")
    @SerializedName("date-create")
    private Date dateCreate;
    @ColumnInfo(name = "user_modify")
    @SerializedName("user-modify")
    private int userModify;
    @TypeConverters(DateTypeConverter.class)
    @ColumnInfo(name = "date_modify")
    @SerializedName("date-modify")
    private Date dateModify;
    @ColumnInfo(name = "user_id")
    @SerializedName("user-id")
    private int userId;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private int status;
    @ColumnInfo(name = "email_evento")
    @SerializedName("email-evento")
    private int emailEvento;
    @ColumnInfo(name = "puesto_id")
    @SerializedName("puesto-id")
    private int puestoId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public int getEnvioCorreo() {
        return envioCorreo;
    }

    public void setEnvioCorreo(int envioCorreo) {
        this.envioCorreo = envioCorreo;
    }

    public int getUserGasto() {
        return userGasto;
    }

    public void setUserGasto(int userGasto) {
        this.userGasto = userGasto;
    }

    public int getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(int userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getUserModify() {
        return userModify;
    }

    public void setUserModify(int userModify) {
        this.userModify = userModify;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEmailEvento() {
        return emailEvento;
    }

    public void setEmailEvento(int emailEvento) {
        this.emailEvento = emailEvento;
    }

    public int getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(int puestoId) {
        this.puestoId = puestoId;
    }
}
