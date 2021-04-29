package barbarabilonic.ferit.zad2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import barbarabilonic.ferit.zad2.adapters.PeopleAdapter
import barbarabilonic.ferit.zad2.databinding.FragmentPeopleListBinding
import barbarabilonic.ferit.zad2.listeners.OnAddClickListener
import barbarabilonic.ferit.zad2.listeners.OnImageClickListener
import barbarabilonic.ferit.zad2.listeners.OnListItemClickListener
import barbarabilonic.ferit.zad2.persistence.InspiringPearsonDao
import barbarabilonic.ferit.zad2.persistence.InspiringPeopleDatabaseBuilder
import barbarabilonic.ferit.zad2.persistence.PeopleRepository

class PeopleListFragment : Fragment() {

    private lateinit var onImageClickListener: OnImageClickListener
    private lateinit var peopleListBinding:FragmentPeopleListBinding
    private lateinit var addClickListener: OnAddClickListener
    private lateinit var onListItemClickListener: OnListItemClickListener
    private val peopleRepository : InspiringPearsonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPearsonDao()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        peopleListBinding = FragmentPeopleListBinding.inflate(inflater, container, false)
       // addToDatabase()
        setupRecyclerView()

        peopleListBinding.fabAddNote.setOnClickListener{addClickListener.onAddClick()}
        return peopleListBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnImageClickListener){
            onImageClickListener = context
        }
        if(context is OnAddClickListener){
            addClickListener=context
        }
        if(context is OnListItemClickListener){
            onListItemClickListener=context
        }

    }

    override fun onResume() {
        super.onResume()
        (peopleListBinding.rvPeople.adapter as PeopleAdapter).refreshData(
            peopleRepository.getPeople()
        )
    }

    private fun setupRecyclerView(){
        peopleListBinding.rvPeople.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        peopleListBinding.rvPeople.adapter =
            PeopleAdapter(
                peopleRepository.getPeople(),
                onImageClickListener,
                onListItemClickListener
            )
    }



    companion object {
        const val TAG = "People List"
        fun create() : PeopleListFragment {
            return PeopleListFragment()
        }
    }
}
