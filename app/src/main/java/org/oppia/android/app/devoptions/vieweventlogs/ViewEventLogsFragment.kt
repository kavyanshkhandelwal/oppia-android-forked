package org.oppia.android.app.devoptions.vieweventlogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.oppia.android.app.fragment.FragmentComponentImpl
import org.oppia.android.app.fragment.InjectableFragment
import javax.inject.Inject

/** Fragment to display all event logs. */
class ViewEventLogsFragment : InjectableFragment() {
  @Inject
  lateinit var viewEventLogsFragmentPresenter: ViewEventLogsFragmentPresenter

  companion object {
    fun newInstance(): ViewEventLogsFragment = ViewEventLogsFragment()
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    (fragmentComponent as FragmentComponentImpl).inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View? = viewEventLogsFragmentPresenter.handleCreateView(inflater, container)
}
