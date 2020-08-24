package ru.alexeypanchenko.mobuisdonor.detail

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.detail_fragment.view.*
import ru.alexeypanchenko.mobuisdonor.detail.dependencies.DetailItemRepository
import ru.alexeypanchenko.mobuisdonor.detail.di.DetailComponentProvider
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var inRoute: DetailInRoute

    @Inject
    lateinit var detailItemRepository: DetailItemRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as DetailComponentProvider).detailComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.detail_fragment, container, false)
        val detailItem: DetailItem? = inRoute.getDetailItem(arguments)
        updateUi(view, detailItem)


        Handler().postDelayed({
            updateUi(view, detailItemRepository.getDetailItem(detailItem?.id ?: 0))
        }, 2000)
        return view
    }

    private fun updateUi(view: View, detailItem: DetailItem?) {
        view.title.text = detailItem?.title
        view.description.text = detailItem?.description
        view.additional.text = detailItem?.additionalText
    }
}