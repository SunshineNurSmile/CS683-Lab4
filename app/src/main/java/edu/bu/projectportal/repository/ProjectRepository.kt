package edu.bu.projectportal.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import edu.bu.projectportal.database.Project

interface ProjectRepository {

    fun addProject(project: Project)
    fun delProject(project: Project)
    fun editProject(project: Project)

    fun getAllProjects(): LiveData<List<Project>>
    fun getProjectsbyFavorite(fav: Boolean): LiveData<List<Project>>

    fun searchProject(projId: Long): LiveData<Project>
    fun searchProjectsbyTitle(projTitle:String): LiveData<List<Project>>

    fun count():LiveData<Int>
}