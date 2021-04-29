package barbarabilonic.ferit.zad2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import barbarabilonic.ferit.zad2.model.InspiringPearson
import barbarabilonic.ferit.zad2.listeners.OnPearsonSaveClickListener
import barbarabilonic.ferit.zad2.persistence.PeopleRepository
import barbarabilonic.ferit.zad2.databinding.FragmentAddPearsonBinding
import barbarabilonic.ferit.zad2.persistence.InspiringPearsonDao
import barbarabilonic.ferit.zad2.persistence.InspiringPeopleDatabaseBuilder

class AddPearsonFragment : Fragment() {
    private lateinit var addPearsonBinding : FragmentAddPearsonBinding
    private lateinit var onPearsonSaveClick: OnPearsonSaveClickListener
    private val peopleRepository:InspiringPearsonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPearsonDao()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addPearsonBinding = FragmentAddPearsonBinding.inflate(inflater, container, false)
        addPearsonBinding.btnNewPearsonSave.setOnClickListener{
            savePearson()
            onPearsonSaveClick.onPearsonSave()

        }
        return addPearsonBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnPearsonSaveClickListener){
            onPearsonSaveClick = context
        }
    }

    private fun savePearson(){

        val name=addPearsonBinding.etPearsonNameInput.text.toString()
        val date=addPearsonBinding.etPearsonDateBirthDeathInput.text.toString()
        val description=addPearsonBinding.etPearsonDescriptionInput.text.toString()
        val quote1=addPearsonBinding.etPearsonQuoteInput1.text.toString()
        val quote2= addPearsonBinding.etPearsonQuoteInput2.text.toString()
        val imageURL=addPearsonBinding.etPearsonImageURLInput.text.toString()
        val inspiringPearson= InspiringPearson(
           0,
            name,
            date,
            description,
            quote1,
            quote2,
            imageURL
        )
        peopleRepository.addPearson(inspiringPearson)


    }



    companion object {
        const val TAG = "Add Pearson"
        fun create(): AddPearsonFragment {
            return AddPearsonFragment()
        }
    }
}