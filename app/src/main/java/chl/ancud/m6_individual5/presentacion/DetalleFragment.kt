package chl.ancud.m6_individual5.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chl.ancud.m6_individual5.databinding.FragmentDetalleBinding
import coil.load
import androidx.activity.addCallback
import androidx.navigation.Navigation
import chl.ancud.m6_individual5.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
private const val ARG_PARAM2 = "tipo"
private const val ARG_PARAM3 = "imagen"
private const val ARG_PARAM4 = "precio"

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: Long? = null

    lateinit var binding: FragmentDetalleBinding
    //private val viewModel: TerrenoViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getLong(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        setComponentes()
        binding.flVolver.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_listadoFragment)
        }
        return binding.root
    }

    private fun setComponentes() {
        binding.tvDetalleId.text = param1
        binding.tvDetalleTipo.text = param2
        binding.imgDetalle.load(param3)
        binding.tvDetallePrecio.text = param4.toString()
    }

}