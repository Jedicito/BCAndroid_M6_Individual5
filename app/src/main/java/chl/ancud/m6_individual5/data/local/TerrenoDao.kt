package chl.ancud.m6_individual5.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerreno(terrenoEntity: List<TerrenoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenos(terrenoEntity: List<TerrenoEntity>)

    @Query("Select * from tabla_terreno order by id asc")
    fun getTerrenos(): LiveData<List<TerrenoEntity>>
}