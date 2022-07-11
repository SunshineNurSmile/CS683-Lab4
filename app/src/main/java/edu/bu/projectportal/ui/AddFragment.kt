package edu.bu.projectportal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import edu.bu.projectportal.viewmodel.ProjectViewModel
import edu.bu.projectportal.R
import edu.bu.projectportal.database.Project

class AddFragment : Fragment() {

    private lateinit var projTitle: EditText
    private lateinit var projDesc: EditText
    private lateinit var projAuthor: EditText
    private lateinit var projLink: EditText
    private lateinit var projKeyword: EditText

    private lateinit var submit:Button
    private lateinit var cancel:Button

    companion object {
        @JvmStatic
        fun newInstance() = AddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        projTitle = view.findViewById(R.id.projTitleEdit)
        projDesc =  view.findViewById(R.id.projDescEdit)
        projAuthor = view.findViewById(R.id.projAuthorEdit)
        projLink = view.findViewById(R.id.projLinkEdit)
        projKeyword = view.findViewById(R.id.projKeywordEdit)

        submit = view.findViewById<Button>(R.id.submit)
        cancel = view.findViewById<Button>(R.id.cancel)

        val viewModel =
            ViewModelProvider(requireActivity()).get(ProjectViewModel::class.java)

        submit.setOnClickListener {
            val project = Project(0, projTitle.text.toString(), projDesc.text.toString(), projAuthor.text.toString(), projLink.text.toString(), projKeyword.text.toString())
            viewModel.addProject(project)
            viewModel.setCurProject(project)

            view.findNavController().navigate(R.id.action_addFragment_pop) }

        cancel.setOnClickListener {
            view.findNavController().
            navigate(R.id.action_addFragment_pop)

        }
  }
}