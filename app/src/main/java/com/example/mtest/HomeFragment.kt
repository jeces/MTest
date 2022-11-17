package com.example.mtest

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment_2.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val TAG = HomeFragment::class.java.simpleName
    lateinit var viewModel : MainViewModel

    override fun onAttach(context: Context) {
        Log.d("jecesHomeFragment", "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("jecesHomeFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.d("jecesHomeFragment", "onCreateView")
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        Log.d("jecesAddFragment", viewModel.pageData.toString())
        return inflater.inflate(R.layout.homefragment, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.d("jecesHomeFragment", "onViewStateRestored")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        Log.d("jecesHomeFragment", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("jecesHomeFragment", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("jecesHomeFragment", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("jecesHomeFragment", "onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("jecesHomeFragment", "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.d("jecesHomeFragment", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("jecesHomeFragment", "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("jecesHomeFragment", "onDetach")
        super.onDetach()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment_2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}