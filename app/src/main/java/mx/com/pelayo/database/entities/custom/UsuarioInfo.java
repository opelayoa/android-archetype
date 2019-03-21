package mx.com.pelayo.database.entities.custom;

public class UsuarioInfo {
    private Integer id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer sucusalId;
    private String sucursalDesc;
    private Integer regionId;
    private String regionDesc;
    private Integer perfilId;
    private String perfilDesc;
    private Integer puestoId;
    private String puesto_desc;
    private Integer departamentoId;
    private String departamentoDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSucusalId() {
        return sucusalId;
    }

    public void setSucusalId(Integer sucusalId) {
        this.sucusalId = sucusalId;
    }

    public String getSucursalDesc() {
        return sucursalDesc;
    }

    public void setSucursalDesc(String sucursalDesc) {
        this.sucursalDesc = sucursalDesc;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionDesc() {
        return regionDesc;
    }

    public void setRegionDesc(String regionDesc) {
        this.regionDesc = regionDesc;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getPerfilDesc() {
        return perfilDesc;
    }

    public void setPerfilDesc(String perfilDesc) {
        this.perfilDesc = perfilDesc;
    }

    public Integer getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Integer puestoId) {
        this.puestoId = puestoId;
    }

    public String getPuesto_desc() {
        return puesto_desc;
    }

    public void setPuesto_desc(String puesto_desc) {
        this.puesto_desc = puesto_desc;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getDepartamentoDesc() {
        return departamentoDesc;
    }

    public void setDepartamentoDesc(String departamentoDesc) {
        this.departamentoDesc = departamentoDesc;
    }
}
