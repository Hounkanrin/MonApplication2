package fr.istic.ccn2.myapplication2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ClientItem.class}, version = 1)
public abstract class ClientDatabase extends RoomDatabase {
    public abstract ClientDao clientDao();
}
