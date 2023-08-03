package chl.ancud.m6_individual5.data

import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.data.remote.TerrenoAPI

class Repositorio(private val terrenoApi: TerrenoAPI) {
    suspend fun getTerrenos(): List<Terreno> {
        val response = terrenoApi.getData()
        if(response.isSuccessful) {
            val resp = response.body()
            resp?.let {
                return it
            }
        }
        return emptyList()

    }

}