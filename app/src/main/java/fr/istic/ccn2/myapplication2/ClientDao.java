package fr.istic.ccn2.myapplication2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClientDao {

    @Query("SELECT * FROM clientitem")
    List<ClientItem> getAllClient();

    @Insert
    void insertAll(ClientItem... clientItems);

}
