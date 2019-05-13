package dev.chahinem.pageindicator.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.chahinem.pageindicator.sample.R.color
import com.chahinem.pageindicator.sample.R.id
import com.chahinem.pageindicator.sample.R.layout
import dev.chahinem.pageindicator.sample.MyAdapter.MyItem
import com.squareup.picasso.Picasso

class MyPagerAdapter(private val picasso: Picasso,
                     private val items: List<MyItem>) : PagerAdapter() {

  override fun getCount() = items.size

  override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    val view = LayoutInflater
        .from(container.context)
        .inflate(layout.item_card, container, false)

    val item = items[position]
    val title: TextView = view.findViewById(id.title)
    val caption: TextView = view.findViewById(id.caption)
    val image: ImageView = view.findViewById(id.image)

    picasso
        .load(item.image)
        .placeholder(color.colorPrimaryDark)
        .fit()
        .centerCrop()
        .into(image)
    title.text = item.title
    caption.text = item.caption

    container.addView(view)
    return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
    container.removeView(view as View)
  }
}