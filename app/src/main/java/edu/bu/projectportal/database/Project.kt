package edu.bu.projectportal.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "projects")
data class Project(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var title: String,
    var description: String,
    var author: String,
    var link: String,
    var keyword: String,
    var favorite: Boolean = false
    )