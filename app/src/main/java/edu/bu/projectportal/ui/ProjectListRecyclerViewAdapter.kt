package edu.bu.projectportal.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import edu.bu.projectportal.database.Project
import edu.bu.projectportal.databinding.FragmentProjectItemBinding


class ProjectListRecyclerViewAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ProjectListRecyclerViewAdapter.ViewHolder>() {

    private val projectList = mutableListOf<Project>()
    private lateinit var curProject: Project

    interface OnClickListener {
        fun onItemClick(projPos:Int, projId:Long);
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentProjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        curProject = projectList[position]
        holder.titleView.text = curProject.title

        holder.cardView.setOnClickListener {cardView ->
            onClickListener.onItemClick(position,curProject.id)

        }
    }

    override fun getItemCount(): Int = projectList.size

    inner class ViewHolder(binding: FragmentProjectItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val titleView: TextView = binding.projTitleItem
        val cardView: CardView = binding.projectCard


        override fun toString(): String {
            return super.toString() + " '" + titleView.text + "'"
        }
    }

    fun replaceItems(projects: List<Project>) {
        projectList.clear()
        projectList.addAll(projects)
        notifyDataSetChanged()
    }

    fun getProject(pos: Int):Project{
       if (projectList.size > 0)
           return projectList[pos]
        else return Project(0,"","", "", "", "")
    }

    fun getFavProject(pos: Int): Project {
        if (projectList[pos].favorite) {
            return projectList[pos]
        }else{
            return Project(0,"","", "", "", "")
        }
    }
}