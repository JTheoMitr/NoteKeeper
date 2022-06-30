package android.example.notekeeper

import android.R
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.notekeeper.databinding.FragmentNewNoteBinding
import android.util.Log
import android.widget.ArrayAdapter


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewNoteFragment : Fragment() {

    private var _binding: FragmentNewNoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var notePosition = POSITION_NOT_SET


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        notePosition = arguments?.getInt(EXTRA_NOTE_POSITION, POSITION_NOT_SET)!!


        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapterCourses = context?.let {
            ArrayAdapter<CourseInfo>(
                it,
                R.layout.simple_spinner_item,
                DataManager.courses.values.toList())
        }

        adapterCourses?.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.spinnerCourses.adapter = adapterCourses


        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        }


//        binding.buttonFirst.setOnClickListener {
//            //findNavController().navigate(R.id.action_NewNoteFragment_to_NoteListFragment)
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

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        binding.textNoteTitle.setText(note.title)
        binding.textNoteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        Log.d("course", "index is ${DataManager.courses.values.indexOf(note.course)}")
        binding.spinnerCourses.setSelection(coursePosition)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}