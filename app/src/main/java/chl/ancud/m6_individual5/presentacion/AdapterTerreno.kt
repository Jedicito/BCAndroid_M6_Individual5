package chl.ancud.m6_individual5.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.databinding.ItemTerrenoBinding
import coil.load

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {
    lateinit var binding: ItemTerrenoBinding
    private val listaTerrenos = mutableListOf<Terreno>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTerreno.ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context))
        return ItemTerrenoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterTerreno.ItemTerrenoViewHolder, position: Int) {
        val terreno = listaTerrenos[position]
        holder.bind(terreno)
    }

    override fun getItemCount(): Int {
        return listaTerrenos.size
    }

    fun setData(listaTerrenos: List<Terreno>) {
        this.listaTerrenos.clear()
        this.listaTerrenos.addAll(listaTerrenos)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val binding: ItemTerrenoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(terreno: Terreno) {
            binding.imgTerreno.load(terreno.imagen)
            binding.tvTipo.text = terreno.tipo
            binding.tvPrecio.text = terreno.precio.toString()
        }

    }

}