package mx.com.pelayo.modules.database;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mx.com.pelayo.database.RoomDatabase;
import mx.com.pelayo.database.dao.UsuarioDao;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    RoomDatabase provideRoomDataBase(Application application) {
        RoomDatabase roomDatabase = RoomDatabase.getDatabase(application.getApplicationContext());
        return roomDatabase;
    }

    @Provides
    @Singleton
    public UsuarioDao provideUsuarioDao(RoomDatabase roomDatabase) {
        return roomDatabase.usuarioDao();
    }

}
