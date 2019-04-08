package mx.com.pelayo.database.dao.ticket;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;

@Dao
public interface TicketAddDao {

    @Query("select * from usuario where sucursal_id in (select id from sucursal where almacen_id in (select distinct id from sucursal where cast(numero3b as integer) = :regionId)) and status = 1 order by id asc")
    LiveData<List<Usuario>> getAllUsuarios(Integer regionId);

    @Query("select rclave as id , rclave || ' - ' || rdesc as label from region")
    LiveData<List<ItemAutocomplete>> getAllRegions();

    @Query("select id, apellido || ', ' || nombre as label from usuario where departamento_id = :departmentId and status = 1")
    LiveData<List<ItemAutocomplete>> getAllTechnicianByDepartment(Integer departmentId);

    @Query("select id, apellido || ', ' || nombre as label from usuario where id in (select distinct tecnico_id from sucursal where cast(numero3b as integer) = :regionId);")
    LiveData<List<ItemAutocomplete>> getAllTechnicianByRegion(Integer regionId);

    @Query("select dclave as id, 'Distrito - ' || dclave as label from distrito where zona_id in (select zonaid from zona where rclave = :regionId) order by dclave")
    LiveData<List<ItemAutocomplete>> getAllDistritosByRegion(Integer regionId);

    @Query("select tclave as id, tnombre as label from tienda where dclave = :distritoId")
    LiveData<List<ItemAutocomplete>> getAllTiendasByDistrito(Integer distritoId);

    @Query("select id, nombre as label from departamento")
    LiveData<List<ItemAutocomplete>> getAllDepartments();

    @Query("select id, apellido || ', ' || nombre as label from usuario where departamento_id = :departmentId order by apellido")
    LiveData<List<ItemAutocomplete>> getAllUsuariosByDepartment(Integer departmentId);

    @Query("select id, descripcion as label from diagnostico where id = :diagnosticId")
    LiveData<ItemAutocomplete> getDiagnosticById(Integer diagnosticId);

    @Query("select id from tipo_sintoma where tipo_id = :typeId and sintoma_id = :symptomId")
    Integer getTipoSintomaId(Integer typeId, Integer symptomId);

    @Query("select sintoma from tipo_sintoma where tipo_id = :typeId and sintoma_id = :symptomId")
    String getTipoSintomaName(Integer typeId, Integer symptomId);

    @Query("select id from sintoma_diagnostico where sintoma_id = :symptomId and diagnostico_id = :diagnosticId")
    Integer getSintomaDiagnosticoId(Integer symptomId, Integer diagnosticId);

    @Query("select diagnostico from sintoma_diagnostico where sintoma_id = :symptomId and diagnostico_id = :diagnosticId")
    String getSintomaDiagnosticoName(Integer symptomId, Integer diagnosticId);
}
