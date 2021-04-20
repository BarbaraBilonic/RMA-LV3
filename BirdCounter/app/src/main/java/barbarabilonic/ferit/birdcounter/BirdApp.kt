package barbarabilonic.ferit.birdcounter

import android.app.Application
import android.content.Context

class BirdApp:Application() {
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}