package mx.com.pelayo.database.entities.composed;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

import mx.com.pelayo.database.entities.Puestos;
import mx.com.pelayo.database.entities.security.UsuarioActual;

public class UsuarioActualComposed {
    @Embedded
    public UsuarioActual usuarioActual;

    @Relation(parentColumn = "puesto_id", entityColumn = "id")
    public List<Puestos> puestos;
}
