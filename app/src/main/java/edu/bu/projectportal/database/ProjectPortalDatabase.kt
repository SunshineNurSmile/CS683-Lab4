package edu.bu.projectportal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.bu.projectportal.database.Project
import edu.bu.projectportal.database.ProjectDao


// define database configuraiton, and the access point to the database
@Database(
    entities = [Project::class],
    version = 1
)
abstract class ProjectPortalDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao
}