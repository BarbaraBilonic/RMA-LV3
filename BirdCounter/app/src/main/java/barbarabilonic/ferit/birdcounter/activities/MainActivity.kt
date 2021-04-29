package barbarabilonic.ferit.birdcounter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import barbarabilonic.ferit.birdcounter.SharedPreferencesManager
import barbarabilonic.ferit.birdcounter.databinding.ActivityMainBinding
import barbarabilonic.ferit.birdcounter.utilities.getBorderResource
import barbarabilonic.ferit.birdcounter.model.BirdCounter

class MainActivity : AppCompatActivity() {
    private val sharedPrefs= SharedPreferencesManager()
    private val birdCounter= BirdCounter()
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        mainBinding.btnBlackBird.setOnClickListener { birdSeen(3) }
        mainBinding.btnBrownBird.setOnClickListener { birdSeen(1) }
        mainBinding.btnGreyBird.setOnClickListener { birdSeen(2) }
        mainBinding.btnYellowBird.setOnClickListener { birdSeen(4) }
        mainBinding.btnReset.setOnClickListener { reset() }
        setContentView(mainBinding.root)
    }

    fun birdSeen(color:Int){
        birdCounter.seeBird()
        birdCounter.setColor(color)
        sharedPrefs.saveData(birdCounter.getBirdCount(),birdCounter.getColor())
        updateUi()

    }

    fun reset(){
        birdCounter.resetBirdCount()
        birdCounter.setColor(0)
        sharedPrefs.saveData(birdCounter.getBirdCount(),birdCounter.getColor())
        updateUi()


    }

    fun updateUi(){

        mainBinding.tvBirdCount.text=birdCounter.getBirdCount().toString()
        mainBinding.tvBirdCount.setBackgroundResource(getBorderResource(birdCounter.getColor()))


    }

    override fun onResume(){
        super.onResume()
        setUp()
    }
    fun setUp(){
        birdCounter.setBirdCount(sharedPrefs.retrieveCount())
        birdCounter.setColor(sharedPrefs.retrieveColor())
        updateUi()
    }



}