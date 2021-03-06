package dev.chahinem.pageindicator.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chahinem.pageindicator.sample.R.color
import com.chahinem.pageindicator.sample.R.id
import com.chahinem.pageindicator.sample.R.layout
import dev.chahinem.pageindicator.sample.MyAdapter.MyViewHolder
import com.squareup.picasso.Picasso

class MyAdapter(private val picasso: Picasso) : RecyclerView.Adapter<MyViewHolder>() {

  private val items: MutableList<MyItem> = mutableListOf()

  override fun getItemCount() = items.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
      LayoutInflater
          .from(parent.context)
          .inflate(layout.item_card, parent, false))

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(picasso, items[holder.adapterPosition])
  }

  fun swapData(data: Iterable<MyItem>?) {
    items.clear()
    data?.let { items.addAll(data) }
    notifyDataSetChanged()
  }

  class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(id.title)
    private val caption: TextView = itemView.findViewById(id.caption)
    private val image: ImageView = itemView.findViewById(id.image)

    fun bind(picasso: Picasso, item: MyItem) {
      picasso
          .load(item.image)
          .placeholder(color.colorPrimaryDark)
          .fit()
          .centerCrop()
          .into(image)
      title.text = item.title
      caption.text = item.caption
    }
  }

  class MyItem(val title: String, val caption: String, val image: String)
}