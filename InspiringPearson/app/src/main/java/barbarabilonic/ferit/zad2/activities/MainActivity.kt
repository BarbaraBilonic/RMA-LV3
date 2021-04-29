package barbarabilonic.ferit.zad2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import barbarabilonic.ferit.zad2.*
import barbarabilonic.ferit.zad2.databinding.ActivityMainBinding
import barbarabilonic.ferit.zad2.fragments.AddPearsonFragment
import barbarabilonic.ferit.zad2.fragments.EditPearsonFragment
import barbarabilonic.ferit.zad2.fragments.PeopleListFragment
import barbarabilonic.ferit.zad2.listeners.*
import barbarabilonic.ferit.zad2.model.InspiringPearson
import barbarabilonic.ferit.zad2.persistence.PeopleRepository

class MainActivity : AppCompatActivity() ,
    OnImageClickListener,
    OnPearsonSaveClickListener,
    OnAddClickListener,
    OnListItemClickListener,
    EditFragmentOnClickListener {
    private lateinit var mainBinding: ActivityMainBinding
    private  var peopleListFragment =
        PeopleListFragment.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fl_fragmentContainer, peopleListFragment,
                    PeopleListFragment.TAG
                )
                .commit()
        }
    }



    override fun onImageClick(quote: String) {
        Toast.makeText(this@MainActivity,quote, Toast.LENGTH_LONG).show()
    }

    override fun onPearsonSave() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer, peopleListFragment,
                PeopleListFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onAddClick() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                AddPearsonFragment.create(),
                AddPearsonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onListItemClick(pearson: InspiringPearson) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer,
                EditPearsonFragment(pearson),
                EditPearsonFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onDeleteButtonClick() {

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer, peopleListFragment,
                PeopleListFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onDoneButtonClick() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fl_fragmentContainer, peopleListFragment,
                PeopleListFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }
}

