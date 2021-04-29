package barbarabilonic.ferit.zad2

import android.app.Application

class InspiringPeople : Application() {

    companion object{
        lateinit var application:InspiringPeople
    }

    override fun onCreate() {
        super.onCreate()
        application=this
    }
}