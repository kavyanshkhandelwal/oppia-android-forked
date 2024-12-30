package org.oppia.android.app.survey

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.ObservableList
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import org.oppia.android.app.recyclerview.BindableAdapter
import org.oppia.android.app.shim.ViewBindingShim
import org.oppia.android.app.survey.surveyitemviewmodel.MultipleChoiceOptionContentViewModel
import org.oppia.android.app.view.ViewComponentFactory
import org.oppia.android.app.view.ViewComponentImpl
import javax.inject.Inject

/**
 * A custom [RecyclerView] for displaying a variable list of items that may be selected by a user as
 * part of the multiple choice option selection.
 */
class SurveyMultipleChoiceOptionView
  @JvmOverloads
  constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
  ) : RecyclerView(context, attrs, defStyleAttr) {
    @Inject
    lateinit var bindingInterface: ViewBindingShim

    @Inject
    lateinit var singleTypeBuilderFactory: BindableAdapter.SingleTypeBuilder.Factory
    private lateinit var dataList: ObservableList<MultipleChoiceOptionContentViewModel>

    override fun onAttachedToWindow() {
      super.onAttachedToWindow()
      val viewComponentFactory = FragmentManager.findFragment<Fragment>(this) as ViewComponentFactory
      val viewComponent = viewComponentFactory.createViewComponent(this) as ViewComponentImpl
      viewComponent.inject(this)
      maybeInitializeAdapter()
    }

    /**
     * Sets the view's RecyclerView [MultipleChoiceOptionContentViewModel] data list.
     *
     * Note that this needs to be used instead of the generic RecyclerView 'data' binding adapter
     * since this one takes into account initialization order with other binding properties.
     */
    fun setSelectionData(dataList: ObservableList<MultipleChoiceOptionContentViewModel>) {
      this.dataList = dataList
      maybeInitializeAdapter()
    }

    private fun maybeInitializeAdapter() {
      if (::singleTypeBuilderFactory.isInitialized &&
        ::dataList.isInitialized
      ) {
        adapter = createAdapter().also { it.setData(dataList) }
      }
    }

    private fun createAdapter(): BindableAdapter<MultipleChoiceOptionContentViewModel> =
      singleTypeBuilderFactory
        .create<MultipleChoiceOptionContentViewModel>()
        .registerViewBinder(
          inflateView = { parent ->
            bindingInterface.provideMultipleChoiceItemsInflatedView(
              LayoutInflater.from(parent.context),
              parent,
              // attachToParent=
              false,
            )
          },
          bindView = { view, viewModel ->
            bindingInterface.provideMultipleChoiceOptionViewModel(
              view,
              viewModel,
            )
          },
        ).build()
  }
