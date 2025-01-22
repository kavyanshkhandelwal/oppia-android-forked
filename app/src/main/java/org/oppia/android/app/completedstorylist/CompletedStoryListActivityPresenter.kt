package org.oppia.android.app.completedstorylist

import androidx.appcompat.app.AppCompatActivity
import org.oppia.android.R
import org.oppia.android.app.activity.ActivityScope
import org.oppia.android.app.model.ProfileId
import javax.inject.Inject

/** The presenter for [CompletedStoryListActivity]. */
@ActivityScope
class CompletedStoryListActivityPresenter
  @Inject
  constructor(
    private val activity: AppCompatActivity,
  ) {
    /** Initializes views for [CompletedStoryListActivity] and binds [CompletedStoryListFragment]. */
    fun handleOnCreate(internalProfileId: Int) {
      activity.setContentView(R.layout.completed_story_list_activity)
      if (getCompletedStoryListFragment() == null) {
        activity
          .supportFragmentManager
          .beginTransaction()
          .add(
            R.id.completed_story_list_fragment_placeholder,
            CompletedStoryListFragment.newInstance(internalProfileId),
            CompletedStoryListFragment.COMPLETED_STORY_LIST_FRAGMENT_TAG,
          ).commitNow()
      }
    }

<<<<<<< HEAD
    private fun getCompletedStoryListFragment(): CompletedStoryListFragment? =
=======
  /** Initializes views for [CompletedStoryListActivity] and binds [CompletedStoryListFragment]. */
  fun handleOnCreate(profileId: ProfileId) {
    activity.setContentView(R.layout.completed_story_list_activity)
    if (getCompletedStoryListFragment() == null) {
>>>>>>> 42210e8069394528330be84c5f4893bb2dafc2bf
      activity
        .supportFragmentManager
        .findFragmentById(
          R.id.completed_story_list_fragment_placeholder,
<<<<<<< HEAD
        ) as CompletedStoryListFragment?
=======
          CompletedStoryListFragment.newInstance(profileId),
          CompletedStoryListFragment.COMPLETED_STORY_LIST_FRAGMENT_TAG
        ).commitNow()
    }
>>>>>>> 42210e8069394528330be84c5f4893bb2dafc2bf
  }
