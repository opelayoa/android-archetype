package mx.com.pelayo.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "proveedor")
public class Proveedor implements java.io.Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Integer id;
    @ColumnInfo(name = "razonsocial")
    @SerializedName("razonsocial")
    private String razonsocial;
    @ColumnInfo(name = "descripcion")
    @SerializedName("descripcion")
    private String descripcion;
    @ColumnInfo(name = "rfc")
    @SerializedName("rfc")
    private String rfc;
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
    @ColumnInfo(name = "telefono1")
    @SerializedName("telefono1")
    private String telefono1;
    @ColumnInfo(name = "extension1")
    @SerializedName("extension1")
    private String extension1;
    @ColumnInfo(name = "telefono2")
    @SerializedName("telefono2")
    private String telefono2;
    @ColumnInfo(name = "extension2")
    @SerializedName("extension2")
    private String extension2;
    @ColumnInfo(name = "cont1")
    @SerializedName("cont1")
    private String cont1;
    @ColumnInfo(name = "telefonocont1")
    @SerializedName("telefonocont1")
    private String telefonocont1;
    @ColumnInfo(name = "emailcont1")
    @SerializedName("emailcont1")
    private String emailcont1;
    @ColumnInfo(name = "cont2")
    @SerializedName("cont2")
    private String cont2;
    @ColumnInfo(name = "telefonocont2")
    @SerializedName("telefonocont2")
    private String telefonocont2;
    @ColumnInfo(name = "emailcont2")
    @SerializedName("emailcont2")
    private String emailcont2;
    @ColumnInfo(name = "cuenta")
    @SerializedName("cuenta")
    private String cuenta;
    @ColumnInfo(name = "dias_entrega")
    @SerializedName("dias-entrega")
    private Integer diasEntrega;
    @ColumnInfo(name = "dias_pago")
    @SerializedName("dias-pago")
    private Integer diasPago;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    private Integer status;
    @ColumnInfo(name = "clave")
    @SerializedName("clave")
    private String clave;
    @ColumnInfo(name = "contrato")
    @SerializedName("contrato")
    private String contrato;
    @ColumnInfo(name = "acta")
    @SerializedName("acta")
    private String acta;
    @ColumnInfo(name = "identificacion")
    @SerializedName("identificacion")
    private String identificacion;

    public Proveedor() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonsocial() {
        return this.razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public String getTelefono1() {
        return this.telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getExtension1() {
        return this.extension1;
    }

    public void setExtension1(String extension1) {
        this.extension1 = extension1;
    }

    public String getTelefono2() {
        return this.telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getExtension2() {
        return this.extension2;
    }

    public void setExtension2(String extension2) {
        this.extension2 = extension2;
    }

    public String getCont1() {
        return this.cont1;
    }

    public void setCont1(String cont1) {
        this.cont1 = cont1;
    }

    public String getTelefonocont1() {
        return this.telefonocont1;
    }

    public void setTelefonocont1(String telefonocont1) {
        this.telefonocont1 = telefonocont1;
    }

    public String getEmailcont1() {
        return this.emailcont1;
    }

    public void setEmailcont1(String emailcont1) {
        this.emailcont1 = emailcont1;
    }

    public String getCont2() {
        return this.cont2;
    }

    public void setCont2(String cont2) {
        this.cont2 = cont2;
    }

    public String getTelefonocont2() {
        return this.telefonocont2;
    }

    public void setTelefonocont2(String telefonocont2) {
        this.telefonocont2 = telefonocont2;
    }

    public String getEmailcont2() {
        return this.emailcont2;
    }

    public void setEmailcont2(String emailcont2) {
        this.emailcont2 = emailcont2;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Integer getDiasEntrega() {
        return this.diasEntrega;
    }

    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public Integer getDiasPago() {
        return this.diasPago;
    }

    public void setDiasPago(Integer diasPago) {
        this.diasPago = diasPago;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getContrato() {
        return this.contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getActa() {
        return this.acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
