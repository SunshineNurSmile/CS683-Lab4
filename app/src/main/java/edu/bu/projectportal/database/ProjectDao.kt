package edu.bu.projectportal.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface ProjectDao {
//    @Insert
//    fun addProjects(projects:List<Project>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProject(project:Project)

    @Delete
    fun delProject(project:Project)

    @Query("SELECT count(*) From projects")
    fun count(): LiveData<Int>


    @Query("SELECT * FROM projects")
    fun getAllProjects(): LiveData<List<Project>>

    @Query("SELECT * FROM projects where id = :projId")
    fun searchProject(projId: Long): LiveData<Project>

    @Query("SELECT * FROM projects WHERE title like :projTitle ")
    fun searchProjectsbyTitle(projTitle:String): LiveData<List<Project>>

    @Query("SELECT * FROM projects WHERE favorite = :projFavorite")
    fun getPojectsbyFavorite(projFavorite: Boolean): LiveData<List<Project>>

    @Update
    fun editProject(project: Project)

}