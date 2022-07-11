package edu.bu.projectportal.repository

import androidx.lifecycle.LiveData
import edu.bu.projectportal.database.Project
import edu.bu.projectportal.database.ProjectDao
import java.util.concurrent.Executor


class ProjectRepositoryImp(
    private val executor: Executor,
    private val projectDao: ProjectDao
) : ProjectRepository {


    override fun addProject(project: Project){
        executor.execute {
            projectDao.addProject(project)
        }
    }

    override fun delProject(project: Project) {
        executor.execute {
            projectDao.delProject(project)
        }
    }

    override fun editProject(project: Project) {
        executor.execute {
            projectDao.editProject(project)
        }
    }

    override fun getAllProjects(): LiveData<List<Project>> {
        val projects = projectDao.getAllProjects()
        return projects
    }

    override fun getProjectsbyFavorite(fav: Boolean): LiveData<List<Project>> {
        val projects = projectDao.getPojectsbyFavorite(fav)
        return projects
    }

    override fun searchProject(projId: Long): LiveData<Project>{
        return projectDao.searchProject(projId)
    }

    override fun searchProjectsbyTitle(projTitle:String): LiveData<List<Project>> {
        return projectDao.searchProjectsbyTitle(projTitle)
    }

    override fun count(): LiveData<Int>{
        return projectDao.count()
    }
}