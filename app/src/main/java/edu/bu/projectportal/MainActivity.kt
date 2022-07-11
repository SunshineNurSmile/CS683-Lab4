package edu.bu.projectportal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController

import edu.bu.projectportal.ui.ProjectListFragment

class MainActivity : AppCompatActivity(), ProjectListFragment.OnClickAddProjListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onClickAddProj() {
        try {
            findViewById<FragmentContainerView>(R.id.detailContainerId)
                ?.findNavController()?.navigate(R.id.action_detailFragment_to_addFragment)
        } catch (e: java.lang.IllegalArgumentException) {

        }
    }

}



