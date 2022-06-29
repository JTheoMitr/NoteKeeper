package android.example.notekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.notekeeper.databinding.FragmentNoteListBinding
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
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

        binding.btnMove.setOnClickListener {
            findNavController().navigate(R.id.action_NoteListFragment_to_NewNoteFragment)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_NoteListFragment_to_NewNoteFragment)
        }

        binding.listNotes.adapter = context?.let {
            ArrayAdapter(it, android.R.layout.simple_list_item_1, DataManager.notes)
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