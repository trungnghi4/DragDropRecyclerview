package ntn.project.dropdragrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DefaultAdapter(private val dataSet: MutableList<IceCream>, private val onClickDefault:OnClickDefault) :
    RecyclerView.Adapter<DefaultAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val cardViewDefault: CardView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.ice_cream_name)
            cardViewDefault = view.findViewById(R.id.cardview_default)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_default, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].name
        viewHolder.cardViewDefault.setOnClickListener {
            onClickDefault.onClickItem(position)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    interface OnClickDefault {
        fun onClickItem(position: Int)
    }
}

