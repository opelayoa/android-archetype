package mx.com.pelayo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import mx.com.pelayo.database.dao.UsuarioDao;
import mx.com.pelayo.database.entities.Usuario;

@Database(entities = {Usuario.class}, version = 1)
@TypeConverters({DateTypeConverter.class})
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {

    public abstract UsuarioDao usuarioDao();

    private static volatile RoomDatabase INSTANCE;

    public static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
