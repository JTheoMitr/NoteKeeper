package android.example.notekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.notekeeper.databinding.FragmentNoteListBinding
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // simple button logic to navigate to First Fragment:

        binding.floatingActionButton.setOnClickListener {

            // added a bundle with default values for new note, was crashing with nullPointerException without this blank bundle? was getting thrown by notePosition in newNote code
            val bundle = bundleOf(
                EXTRA_NOTE_POSITION to -1
            )

            findNavController().navigate(R.id.action_NoteListFragment_to_NewNoteFragment, bundle)
        }

        binding.listNotes.adapter = context?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1, DataManager.notes)
        }

        binding.listNotes.setOnItemClickListener { parent, view, position, id ->

                val bundle = bundleOf(
                    EXTRA_NOTE_POSITION to position
                )

            findNavController().navigate(R.id.action_NoteListFragment_to_NewNoteFragment,
            bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "Note List"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}