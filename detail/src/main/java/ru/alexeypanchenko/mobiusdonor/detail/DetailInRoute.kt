package ru.alexeypanchenko.mobiusdonor.detail

import android.os.Bundle

private const val ITEM_KEY = "detail_item_key"

class DetailInRoute {

    fun detailFragment(item: DetailItem): DetailFragment {
        val bundle = Bundle().apply {
            putSerializable(ITEM_KEY, item)
        }
        return DetailFragment().apply {
            arguments = bundle
        }
    }

    internal fun getDetailItem(bundle: Bundle?): DetailItem? = bundle?.getSerializable(ITEM_KEY) as? DetailItem
}