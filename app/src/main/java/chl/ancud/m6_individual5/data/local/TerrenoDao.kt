package chl.ancud.m6_individual5.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import chl.ancud.m6_individual5.data.remote.Terreno

interface TerrenoDao {
    @Insert
    suspend fun insertTerreno(terrenoEntity: TerrenoEntity)

    @Query("Select * from tabla_terreno order by id asc")
    fun getTareas(): LiveData<List<TerrenoEntity>>
}