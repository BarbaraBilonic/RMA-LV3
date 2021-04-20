package barbarabilonic.ferit.birdcounter

import android.content.Context

class SharedPreferencesManager {
    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_COUNT = "Count"
        const val PREFS_KEY_COLOR="Color"
    }

    fun saveData(count: Int,color:Int) {
        val sharedPreferences = BirdApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.putInt(PREFS_KEY_COUNT, count)
        editor.apply()
        editor.putInt(PREFS_KEY_COLOR,color)
        editor.apply()
    }
    fun retrieveCount(): Int {
        val sharedPreferences = BirdApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_COUNT,R.color.white)
    }
    fun retrieveColor():Int{
        val sharedPreferences = BirdApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_COLOR,0)
    }
}