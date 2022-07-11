package edu.bu.projectportal

import android.app.Application
import androidx.room.Room
import edu.bu.projectportal.database.ProjectPortalDatabase
import edu.bu.projectportal.repository.ProjectRepository
import edu.bu.projectportal.repository.ProjectRepositoryImp
import java.util.concurrent.Executors

class ProjectPortalApplication: Application() {
    lateinit var projectportalDatabase: ProjectPortalDatabase
    lateinit var projectRepository: ProjectRepository

    override fun onCreate() {
        super.onCreate()
        projectportalDatabase =
            Room.databaseBuilder(
                applicationContext, ProjectPortalDatabase::class.java,
                "projectportal-db"
            ).build()
        projectRepository = ProjectRepositoryImp(
            Executors.newSingleThreadExecutor(),
            projectportalDatabase.projectDao())


//            projectRepository.addProject(
//                Project(
//                    0,
//                    "Weather Forecast", "Weather Forcast is an app ..."
//                )
//            );
//            projectRepository.addProject(
//                Project(
//                    0,
//                    "Connect Me", "Connect Me is an app ... "
//                )
//            );
        }

}