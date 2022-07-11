package edu.bu.projectportal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import edu.bu.projectportal.viewmodel.ProjectViewModel
import edu.bu.projectportal.R

class DetailFragment : Fragment() {
    
    private lateinit var projTitle: TextView
    private lateinit var projDesc: TextView
    private lateinit var projAuthor: TextView
    private lateinit var projLink: TextView
    private lateinit var projKeyword: TextView
    private lateinit var favoriteCheckBox: CheckBox

    private lateinit var editProj: ImageButton

    companion object {
        const val PROJECT_ID = "project id"

        @JvmStatic
        fun newInstance(projId: Int) =
            ProjectListFragment().apply {
                arguments = Bundle().apply {
                    putInt(PROJECT_ID, projId)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

       // val projId = arguments?.getInt(PROJECT_ID)?:0

        projTitle =  view.findViewById(R.id.projTitle)
        projDesc =  view.findViewById(R.id.projDesc)
        projAuthor = view.findViewById(R.id.projAuthor)
        projLink = view.findViewById(R.id.projLink)
        projKeyword = view.findViewById(R.id.projKeyword)
        favoriteCheckBox = view.findViewById<CheckBox>(R.id.favoriteCheckBox)

        editProj = view.findViewById(R.id.editProj)

        val viewModel =
            ViewModelProvider(requireActivity()).get(ProjectViewModel::class.java)

        viewModel.curProject.observe(viewLifecycleOwner, Observer {
            projTitle.text = it?.title?:""
            projDesc.text = it?.description?:""
            projAuthor.text = it?.author?:""
            projLink.text = it?.link?:""
            projKeyword.text = it?.keyword?:""
            favoriteCheckBox.isChecked = it?.favorite?:false

        })
        editProj.setOnClickListener{
            view.findNavController().
            navigate(R.id.action_detailFragment_to_editFragment)
        }
        
        favoriteCheckBox.setOnCheckedChangeListener{
            view, isChecked -> viewModel.updateFavorite(isChecked)
        }

    }

    override fun onResume() {
        super.onResume()
    }

}