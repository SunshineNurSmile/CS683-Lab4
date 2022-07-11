package edu.bu.projectportal

import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import edu.bu.projectportal.database.Project
import edu.bu.projectportal.viewmodel.ProjectViewModel
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProjectViewModelTest {
    @Test
    fun updateCurProject() {
        val projectViewModel = ViewModelProvider(ApplicationProvider.getApplicationContext()).
        get(ProjectViewModel::class.java)
        projectViewModel.initCurProject(Project(0,"proj1","proj2", "", "", ""))
        projectViewModel.updateCurProject("proj2", "this is project1... ", "", "", "")
        assertEquals(projectViewModel.curProject.value?.title,"proj1")
    }
}