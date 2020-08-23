package ru.alexeypanchenko.mobuisdonor.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    private val items: MutableList<ListItem> = mutableListOf()

    var itemClickListener: ((ListItem) -> Unit)? = null

    fun setItems(items: List<ListItem>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val holder = ListItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        holder.itemView.setOnClickListener {
            val position: Int = holder.adapterPosition
            if (position == RecyclerView.NO_POSITION) {
                return@setOnClickListener
            }
            itemClickListener?.invoke(items[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val currentItem: ListItem = items[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }
}

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.title)
    val description: TextView = itemView.findViewById(R.id.description)

}