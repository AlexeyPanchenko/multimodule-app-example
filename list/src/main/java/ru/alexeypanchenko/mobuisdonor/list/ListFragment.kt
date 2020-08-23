package ru.alexeypanchenko.mobuisdonor.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_fragment.view.*
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var repository: ItemsRepository

    @Inject
    lateinit var text: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.list_fragment, container, false)
        val list: RecyclerView = view.list
        val adapter = ListAdapter()
        list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter


        (requireActivity().application as ListComponentProvider).listComponent.inject(this)

        adapter.setItems(repository.getItems())

        Log.d("TTT", "Text = ${text}")

        return view
    }
}