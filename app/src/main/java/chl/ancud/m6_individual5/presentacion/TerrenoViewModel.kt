package chl.ancud.m6_individual5.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import chl.ancud.m6_individual5.data.Repositorio
import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.data.remote.TerrenoRetrofit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetrofit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }

    fun getAllTerrenos() = viewModelScope.launch {
        terrenosLiveData.value = repositorio.getTerrenos()
    }
}