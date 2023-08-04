package chl.ancud.m6_individual5.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_terreno")
class TerrenoEntity(
    @PrimaryKey val id: String,
    val tipo: String,
    val precio: Long,
    val imagen: String
)
