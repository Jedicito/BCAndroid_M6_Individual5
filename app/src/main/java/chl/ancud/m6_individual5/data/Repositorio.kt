package chl.ancud.m6_individual5.data

import androidx.lifecycle.LiveData
import chl.ancud.m6_individual5.data.local.TerrenoDao
import chl.ancud.m6_individual5.data.local.TerrenoEntity
import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.data.remote.TerrenoAPI
import retrofit2.Response

class Repositorio(private val terrenoApi: TerrenoAPI, private val terrenoDao: TerrenoDao) {
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.getTerrenos()
    suspend fun getTerrenos() {
        val response: Response<List<Terreno>> = terrenoApi.getData()
        if(response.isSuccessful) {
            val resp: List<Terreno>? = response.body()
            resp?.let {terrenos ->
                val terrenosEntity = terrenos.map {
                    it.transformar()
                }
                terrenoDao.insertTerreno(terrenosEntity)
            }
        }
    }
}

fun Terreno.transformar(): TerrenoEntity = TerrenoEntity(this.id, this.tipo, this.precio,  this.imagen)