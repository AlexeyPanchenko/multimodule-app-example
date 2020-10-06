package ru.alexeypanchenko.donorapp.detail

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.detail_fragment.view.*
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailItemRepository
import ru.alexeypanchenko.donorapp.detail.dependencies.DetailOutRoute
import ru.alexeypanchenko.donorapp.detail.di.DaggerDetailUiComponent
import ru.alexeypanchenko.donorapp.detail.di.DetailDependenciesProvider
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var inRoute: DetailInRoute

    @Inject
    lateinit var outRoute: DetailOutRoute

    @Inject
    lateinit var detailItemRepository: DetailItemRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerDetailUiComponent.builder()
            .detailComponent(DetailDependenciesProvider.getDetailComponent())
            .dependencies(DetailDependenciesProvider.getDetailUiComponentDependencies())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.detail_fragment, container, false)
        val detailItem: DetailItem? = inRoute.getDetailItem(arguments)
        if (detailItem == null) {
            outRoute.goBack()
            return null
        }
        view.toolbar.setNavigationIcon(R.drawable.ic_baseline_delete_24)
        view.toolbar.setNavigationOnClickListener {
            detailItemRepository.removeDetailItem(detailItem.id)
            outRoute.goBack()
        }
        updateUi(view, detailItem)


        Handler().postDelayed({
            updateUi(view, detailItemRepository.getDetailItem(detailItem.id))
        }, 2000)
        return view
    }

    private fun updateUi(view: View, detailItem: DetailItem?) {
        view.title.text = detailItem?.title
        view.description.text = detailItem?.description
        view.additional.text = detailItem?.additionalText
    }

    override fun onDestroy() {
        super.onDestroy()
        DetailDependenciesProvider.clearUiDependencies()
    }
}