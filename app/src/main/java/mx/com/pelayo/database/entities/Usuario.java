package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "usuario")
public class Usuario implements java.io.Serializable {

    @PrimaryKey
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
    private boolean envioCorreo;
    @ColumnInfo(name = "user_gasto")
    @SerializedName("user-gasto")
    private Integer userGasto;
    @ColumnInfo(name = "user_create")
    @SerializedName("user-create")
    private Integer userCreate;
    @ColumnInfo(name = "date_create")
    @SerializedName("date-create")
    private Date dateCreate;
    @ColumnInfo(name = "user_modify")
    @SerializedName("user-modify")
    private Integer userModify;
    @ColumnInfo(name = "date_modify")
    @SerializedName("date-modify")
    private Date dateModify;
    @ColumnInfo(name = "user_id")
    @SerializedName("user-id")
    private int userId;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private Boolean status;
    @ColumnInfo(name = "email_evento")
    @SerializedName("email-evento")
    private boolean emailEvento;
    @ColumnInfo(name = "puesto_id")
    @SerializedName("puesto-id")
    private Integer puestoId;

    public Usuario() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDepartamentoId() {
        return this.departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getSucursalId() {
        return this.sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getPerfilId() {
        return this.perfilId;
    }

    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    public boolean isEnvioCorreo() {
        return this.envioCorreo;
    }

    public void setEnvioCorreo(boolean envioCorreo) {
        this.envioCorreo = envioCorreo;
    }

    public Integer getUserGasto() {
        return this.userGasto;
    }

    public void setUserGasto(Integer userGasto) {
        this.userGasto = userGasto;
    }

    public Integer getUserCreate() {
        return this.userCreate;
    }

    public void setUserCreate(Integer userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return this.dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getUserModify() {
        return this.userModify;
    }

    public void setUserModify(Integer userModify) {
        this.userModify = userModify;
    }

    public Date getDateModify() {
        return this.dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isEmailEvento() {
        return this.emailEvento;
    }

    public void setEmailEvento(boolean emailEvento) {
        this.emailEvento = emailEvento;
    }

    public Integer getPuestoId() {
        return this.puestoId;
    }

    public void setPuestoId(Integer puestoId) {
        this.puestoId = puestoId;
    }

    @Override
    public String toString() {
        return getApellido() + ", " + getNombre();
    }
}
