package chl.ancud.m6_individual5.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import chl.ancud.m6_individual5.data.Repositorio
import chl.ancud.m6_individual5.data.local.TerrenoDao
import chl.ancud.m6_individual5.data.local.TerrenoDatabase
import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.data.remote.TerrenoRetrofit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val api = TerrenoRetrofit.getRetrofitTerreno()
        val terrenoDatabase = TerrenoDatabase.getDatabase(application).getITerrenoDao()
        repositorio = Repositorio(api, terrenoDatabase)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.getTerrenos()
    }

    fun terrenosLiveData() = repositorio.obtenerTerrenos()
}