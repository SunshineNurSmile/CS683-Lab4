package edu.bu.projectportal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.bu.projectportal.ProjectPortalApplication
import edu.bu.projectportal.database.Project
import edu.bu.projectportal.repository.ProjectRepository


class ProjectViewModel(application: Application): AndroidViewModel(application) {
    private val projectRepository: ProjectRepository =
        (application as ProjectPortalApplication).projectRepository

    // use this curProject to update the detail/edit project fragment
    var curProject: MutableLiveData<Project> = MutableLiveData()

    fun initCurProject(project: Project){
        if (curProject.value == null)
            curProject.value = project
    }

    fun setCurProject(project: Project){
        curProject.value = project
    }

    fun isCurProject(project:Project):Boolean{
        return curProject.value?.id == project.id
    }

    fun updateCurProject(title:String, desp: String, auth: String, link: String, key: String) {
        curProject?.value?.apply{
            this?.title = title
            this?.description = desp
            this?.author = auth
            this?.link = link
            this?.keyword = key
        }
        projectRepository.editProject(curProject.value!!)
    }

    fun updateFavorite(fav: Boolean) {
        curProject?.value?.apply{
            this?.favorite = fav
        }
        projectRepository.editProject(curProject.value!!)
    }

    fun getAllProjects(): LiveData<List<Project>> {
        return projectRepository.getAllProjects()
    }

    fun getProjectsbyFavorite(fav: Boolean): LiveData<List<Project>> {
        return projectRepository.getProjectsbyFavorite(fav)
    }

    fun addProject(project: Project){
        projectRepository.addProject(project)
    }
    fun delProject(project: Project){
        projectRepository.delProject(project)
    }
}