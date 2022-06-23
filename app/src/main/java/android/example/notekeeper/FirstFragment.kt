package android.example.notekeeper

import android.R
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.notekeeper.databinding.FragmentFirstBinding
import android.widget.ArrayAdapter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dm = DataManager()
        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                R.layout.simple_spinner_item,
                dm.courses.values.toList())
        }

        adapterCourses?.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.spinnerCourses.adapter = adapterCourses



//        binding.buttonFirst.setOnClickListener {
//            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//            val originalValue = binding.textDisplayedValue.text.toString().toInt()
//            val newValue = originalValue * 2
//            binding.textDisplayedValue.text = newValue.toString()
//
//            Snackbar.make(it, "Value $originalValue changed to $newValue",
//                Snackbar.LENGTH_LONG)
//                .show()
//
//        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}