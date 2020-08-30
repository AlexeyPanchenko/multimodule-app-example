package ru.alexeypanchenko.mobuisdonor.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_fragment.view.*
import ru.alexeypanchenko.mobuisdonor.list.dependencies.ListItemsRepository
import ru.alexeypanchenko.mobuisdonor.list.di.DaggerListUiComponent
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentProvider
import ru.alexeypanchenko.mobuisdonor.list.di.ListComponentsProvider
import javax.inject.Inject

class ListFragment : Fragment() {

    @Inject
    lateinit var repository: ListItemsRepository

    @Inject
    lateinit var router: ListRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerListUiComponent.builder()
            .dependencies(ListComponentsProvider.getListUiComponentDependencies())
            .listComponent(ListComponentsProvider.getListComponent())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.list_fragment, container, false)
        (requireActivity() as AppCompatActivity).setSupportActionBar(view.toolbar)
        (requireActivity() as AppCompatActivity).title = null

        val list: RecyclerView = view.list
        val adapter = ListAdapter()
        list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
        list.setHasFixedSize(true)

        adapter.setItems(repository.getItems())
        adapter.itemClickListener = {
            router.openDetail(it)
        }
        view.toolbar.setNavigationOnClickListener {
            router.openSettings()
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> {
                router.openAdd()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}