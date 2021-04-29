package barbarabilonic.ferit.zad2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import barbarabilonic.ferit.zad2.listeners.EditFragmentOnClickListener
import barbarabilonic.ferit.zad2.persistence.PeopleRepository
import barbarabilonic.ferit.zad2.databinding.EditPearsonFragmentBinding
import barbarabilonic.ferit.zad2.model.InspiringPearson
import barbarabilonic.ferit.zad2.persistence.InspiringPearsonDao
import barbarabilonic.ferit.zad2.persistence.InspiringPeopleDatabaseBuilder

class EditPearsonFragment(private val pearson:InspiringPearson) : Fragment() {
    private lateinit var editPearsonFragmentBinding: EditPearsonFragmentBinding
    private lateinit var editFragmentClickListener: EditFragmentOnClickListener
    private val peopleRepository: InspiringPearsonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPearsonDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        editPearsonFragmentBinding = EditPearsonFragmentBinding.inflate(inflater, container, false)
        setUp()
        editPearsonFragmentBinding.btnDelete.setOnClickListener {
            peopleRepository.removePearson(pearson)
            editFragmentClickListener.onDeleteButtonClick() }
        editPearsonFragmentBinding.btnDone.setOnClickListener {
            getChanges()
            editFragmentClickListener.onDoneButtonClick()
        }
        return editPearsonFragmentBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is EditFragmentOnClickListener){
            editFragmentClickListener=context
        }
    }
    private fun setUp(){

        editPearsonFragmentBinding.etPearsonNameEdit.setText(pearson.name)
        editPearsonFragmentBinding.etPearsonDateBirthDeathEdit.setText(pearson.dateBirthDeath)
        editPearsonFragmentBinding.etPearsonDescriptionEdit.setText(pearson.description)
        editPearsonFragmentBinding.etPearsonQuoteEdit1.setText(pearson.quote1)
        editPearsonFragmentBinding.etPearsonQuoteEdit2.setText(pearson.quote2)
        editPearsonFragmentBinding.etPearsonImageURLEdit.setText(pearson.imageUrl)
    }

    private fun getChanges(){
       pearson.name=editPearsonFragmentBinding.etPearsonNameEdit.text.toString()
        pearson.dateBirthDeath=editPearsonFragmentBinding.etPearsonDateBirthDeathEdit.text.toString()
        pearson.description=editPearsonFragmentBinding.etPearsonDescriptionEdit.text.toString()
        pearson.quote1= editPearsonFragmentBinding.etPearsonQuoteEdit1.text.toString()
        pearson.quote2=editPearsonFragmentBinding.etPearsonQuoteEdit2.text.toString()
        pearson.imageUrl=editPearsonFragmentBinding.etPearsonImageURLEdit.text.toString()
        peopleRepository.updatePearson(pearson)


    }

    companion object {
        const val TAG = "Edit pearson"

    }

}