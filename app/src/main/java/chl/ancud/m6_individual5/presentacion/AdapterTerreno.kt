package chl.ancud.m6_individual5.presentacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m6_individual5.R
import chl.ancud.m6_individual5.data.local.TerrenoEntity
import chl.ancud.m6_individual5.data.remote.Terreno
import chl.ancud.m6_individual5.databinding.ItemTerrenoBinding
import coil.load

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {
    lateinit var binding: ItemTerrenoBinding
    private val listaTerrenos = mutableListOf<TerrenoEntity>()

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

    fun setData(listaTerrenos: List<TerrenoEntity>) {
        this.listaTerrenos.clear()
        this.listaTerrenos.addAll(listaTerrenos)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val binding: ItemTerrenoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(terreno: TerrenoEntity) {
            binding.imgTerreno.load(terreno.imagen)
            binding.tvTipo.text = terreno.tipo
            binding.tvPrecio.text = terreno.precio.toString()
            binding.constraintLayoutItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                bundle.putString("tipo", terreno.tipo)
                bundle.putString("imagen", terreno.imagen)
                bundle.putLong("precio", terreno.precio)
                Navigation.findNavController(binding.root).navigate(
                    R.id.action_listadoFragment_to_detalleFragment, bundle
                )
            }
        }

    }

}