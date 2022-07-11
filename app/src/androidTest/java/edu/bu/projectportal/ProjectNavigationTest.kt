package edu.bu.projectportal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import edu.bu.projectportal.ui.ProjectListRecyclerViewAdapter
import edu.bu.projectportal.viewmodel.ProjectViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ProjectListDetailTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    val curPos = 1
    val curProj = ProjectViewModel.projects[curPos]

    @Test
    fun testShowRecyclerView() {
        Espresso.onView(ViewMatchers.withId(R.id.projectListView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testSelectProject() {
        Espresso.onView(withId(R.id.projectListView))
            .perform(actionOnItemAtPosition<ProjectListRecyclerViewAdapter.ViewHolder>
                (curPos, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.detailFragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.projTitle))
            .check(ViewAssertions.matches(withText(curProj.title)))


        Espresso.onView(withId(R.id.projectListView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}