package com.shanu.helpmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.shanu.helpmodule.databinding.FragmentHelpBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HelpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    private lateinit var helpModuleDataCallback: () -> Unit

    fun registerHelpModuleDataCallback(dataCallback: () -> Unit) {
        helpModuleDataCallback = dataCallback
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                /*val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
                activity?.finish()
                Intent(
                    requireActivity(),
                    Class.forName("com.shanu.nmsuperapp.presentation.activity.LoginActivity")
                ).apply {
                    startActivity(this)
                }.also {
                    activity?.finish()
                }*/
                helpModuleDataCallback.invoke()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout and bind to the _binding
        _binding = FragmentHelpBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }
}