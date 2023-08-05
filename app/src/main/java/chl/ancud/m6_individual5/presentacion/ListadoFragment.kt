package chl.ancud.m6_individual5.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import chl.ancud.m6_individual5.databinding.FragmentListadoBinding

class ListadoFragment : Fragment() {

    lateinit var binding: FragmentListadoBinding
    private val terrenoViewModel: TerrenoViewModel by activityViewModels()
    //private val adapter = AdapterTerreno()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(layoutInflater)
        initListeners()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        //terrenoViewModel.getAllTerrenos()
        val adapter = AdapterTerreno()
        binding.rvListado.adapter = adapter
        terrenoViewModel.terrenosLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun initListeners() {
        binding.btCargar.setOnClickListener {
            terrenoViewModel.getAllTerrenos()
        }
    }

}