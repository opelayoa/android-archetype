package mx.com.pelayo.api.entities;

import com.google.gson.annotations.SerializedName;

public class TicketInfo {
    private Integer id;
    private String estado;
    private String vencido;
    @SerializedName("fecha-apertura")
    private String fechaApertura;
    @SerializedName("fecha-solucion")
    private String fechaSolucion;
    private String leyenda;
    private String solicitante;
    private String tecnico;
    private String categoria;
    private String tipo;
    private String sintoma;
    private String diagnostico;
    private String lugar;
    private String solucion;
    @SerializedName("solucion-remota")
    private boolean solucionRemota;
    @SerializedName("posible-origen")
    private String posibleOrigen;
    @SerializedName("fecha-actualizacion")
    private String fechaActualizacion;
    @SerializedName("esperando-usuario")
    private String esperandoUsuario;
    @SerializedName("esperando-proveedor")
    private String esperandoProveedor;
    @SerializedName("improcedente-motivo")
    private String improcedenteMotivo;
    @SerializedName("fecha-cierre")
    private String fechaCierre;
    private String observaciones;
    private String capturista;
    @SerializedName("correo-manual")
    private boolean correoManual;
    @SerializedName("status-proyecto")
    private String statusProyecto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVencido() {
        return vencido;
    }

    public void setVencido(String vencido) {
        this.vencido = vencido;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(String fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public boolean isSolucionRemota() {
        return solucionRemota;
    }

    public void setSolucionRemota(boolean solucionRemota) {
        this.solucionRemota = solucionRemota;
    }

    public String getPosibleOrigen() {
        return posibleOrigen;
    }

    public void setPosibleOrigen(String posibleOrigen) {
        this.posibleOrigen = posibleOrigen;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEsperandoUsuario() {
        return esperandoUsuario;
    }

    public void setEsperandoUsuario(String esperandoUsuario) {
        this.esperandoUsuario = esperandoUsuario;
    }

    public String getEsperandoProveedor() {
        return esperandoProveedor;
    }

    public void setEsperandoProveedor(String esperandoProveedor) {
        this.esperandoProveedor = esperandoProveedor;
    }

    public String getImprocedenteMotivo() {
        return improcedenteMotivo;
    }

    public void setImprocedenteMotivo(String improcedenteMotivo) {
        this.improcedenteMotivo = improcedenteMotivo;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCapturista() {
        return capturista;
    }

    public void setCapturista(String capturista) {
        this.capturista = capturista;
    }

    public boolean isCorreoManual() {
        return correoManual;
    }

    public void setCorreoManual(boolean correoManual) {
        this.correoManual = correoManual;
    }

    public String getStatusProyecto() {
        return statusProyecto;
    }

    public void setStatusProyecto(String statusProyecto) {
        this.statusProyecto = statusProyecto;
    }
}
