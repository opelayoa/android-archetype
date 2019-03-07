package mx.com.pelayo.database.entities;
// Generated 6/03/2019 08:17:38 AM by Hibernate Tools 4.3.5.Final

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "sucursal")
public class Sucursal implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "numero3b")
    @SerializedName("numero3b")
    private String numero3b;
    @ColumnInfo(name = "nombre")
    @SerializedName("nombre")
    private String nombre;
    @ColumnInfo(name = "calle")
    @SerializedName("calle")
    private String calle;
    @ColumnInfo(name = "numerocalle")
    @SerializedName("numerocalle")
    private String numerocalle;
    @ColumnInfo(name = "colonia")
    @SerializedName("colonia")
    private String colonia;
    @ColumnInfo(name = "municipio")
    @SerializedName("municipio")
    private String municipio;
    @ColumnInfo(name = "ciudad")
    @SerializedName("ciudad")
    private String ciudad;
    @ColumnInfo(name = "codigopostal")
    @SerializedName("codigopostal")
    private String codigopostal;
    @ColumnInfo(name = "telefonofijo")
    @SerializedName("telefonofijo")
    private String telefonofijo;
    @ColumnInfo(name = "telefonocelular")
    @SerializedName("telefonocelular")
    private String telefonocelular;
    @ColumnInfo(name = "tiposucursal_id")
    @SerializedName("tiposucursal-id")
    private int tiposucursalId;
    @ColumnInfo(name = "almacen_id")
    @SerializedName("almacen-id")
    private Integer almacenId;
    @ColumnInfo(name = "distrito_id")
    @SerializedName("distrito-id")
    private Integer distritoId;
    @ColumnInfo(name = "tecnico_id")
    @SerializedName("tecnico-id")
    private int tecnicoId;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private Integer status;
    @ColumnInfo(name = "encargado_id")
    @SerializedName("encargado-id")
    private Integer encargadoId;
    @ColumnInfo(name = "entrega_compra")
    @SerializedName("entrega-compra")
    private Boolean entregaCompra;
    @ColumnInfo(name = "clave")
    @SerializedName("clave")
    private String clave;
    @ColumnInfo(name = "emails")
    @SerializedName("emails")
    private String emails;
    @ColumnInfo(name = "region")
    @SerializedName("region")
    private byte region;
    @ColumnInfo(name = "fechacreate")
    @SerializedName("fechacreate")
    private Date fechacreate;
    @ColumnInfo(name = "usercreate")
    @SerializedName("usercreate")
    private int usercreate;
    @ColumnInfo(name = "usermod")
    @SerializedName("usermod")
    private Integer usermod;
    @ColumnInfo(name = "fechamod")
    @SerializedName("fechamod")
    private Date fechamod;
    @ColumnInfo(name = "userdel")
    @SerializedName("userdel")
    private Integer userdel;
    @ColumnInfo(name = "fechadel")
    @SerializedName("fechadel")
    private Date fechadel;

    public Sucursal() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero3b() {
        return this.numero3b;
    }

    public void setNumero3b(String numero3b) {
        this.numero3b = numero3b;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumerocalle() {
        return this.numerocalle;
    }

    public void setNumerocalle(String numerocalle) {
        this.numerocalle = numerocalle;
    }

    public String getColonia() {
        return this.colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return this.codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTelefonofijo() {
        return this.telefonofijo;
    }

    public void setTelefonofijo(String telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getTelefonocelular() {
        return this.telefonocelular;
    }

    public void setTelefonocelular(String telefonocelular) {
        this.telefonocelular = telefonocelular;
    }

    public int getTiposucursalId() {
        return this.tiposucursalId;
    }

    public void setTiposucursalId(int tiposucursalId) {
        this.tiposucursalId = tiposucursalId;
    }

    public Integer getAlmacenId() {
        return this.almacenId;
    }

    public void setAlmacenId(Integer almacenId) {
        this.almacenId = almacenId;
    }

    public Integer getDistritoId() {
        return this.distritoId;
    }

    public void setDistritoId(Integer distritoId) {
        this.distritoId = distritoId;
    }

    public int getTecnicoId() {
        return this.tecnicoId;
    }

    public void setTecnicoId(int tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEncargadoId() {
        return this.encargadoId;
    }

    public void setEncargadoId(Integer encargadoId) {
        this.encargadoId = encargadoId;
    }

    public Boolean getEntregaCompra() {
        return this.entregaCompra;
    }

    public void setEntregaCompra(Boolean entregaCompra) {
        this.entregaCompra = entregaCompra;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmails() {
        return this.emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public byte getRegion() {
        return this.region;
    }

    public void setRegion(byte region) {
        this.region = region;
    }

    public Date getFechacreate() {
        return this.fechacreate;
    }

    public void setFechacreate(Date fechacreate) {
        this.fechacreate = fechacreate;
    }

    public int getUsercreate() {
        return this.usercreate;
    }

    public void setUsercreate(int usercreate) {
        this.usercreate = usercreate;
    }

    public Integer getUsermod() {
        return this.usermod;
    }

    public void setUsermod(Integer usermod) {
        this.usermod = usermod;
    }

    public Date getFechamod() {
        return this.fechamod;
    }

    public void setFechamod(Date fechamod) {
        this.fechamod = fechamod;
    }

    public Integer getUserdel() {
        return this.userdel;
    }

    public void setUserdel(Integer userdel) {
        this.userdel = userdel;
    }

    public Date getFechadel() {
        return this.fechadel;
    }

    public void setFechadel(Date fechadel) {
        this.fechadel = fechadel;
    }

}
