package barbarabilonic.ferit.zad2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import barbarabilonic.ferit.zad2.*
import barbarabilonic.ferit.zad2.listeners.OnImageClickListener
import barbarabilonic.ferit.zad2.listeners.OnListItemClickListener
import barbarabilonic.ferit.zad2.model.InspiringPearson

class PeopleAdapter (
    people: List<InspiringPearson>,
    private val listener: OnImageClickListener,
    private val onItemClickListener: OnListItemClickListener
) :
    RecyclerView.Adapter<PeopleViewHolder>() {

    private val  people: MutableList<InspiringPearson> = mutableListOf()
    init{
        refreshData(people)
    }

     fun refreshData(people: List<InspiringPearson>) {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pearson, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val pearson = people[position]
        holder.bind(pearson,listener)
        holder.itemView.setOnClickListener { onItemClickListener.onListItemClick(pearson) }

    }

    override fun getItemCount(): Int {
        return people.size
    }
}