package barbarabilonic.ferit.zad2.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import barbarabilonic.ferit.zad2.model.InspiringPearson

@Database(entities= [InspiringPearson::class],version=1)
abstract class InspiringPeopleDatabase : RoomDatabase(){
    abstract fun inspiringPearsonDao():InspiringPearsonDao
    companion object{
        const val NAME = "inspiringPeopleDB"
    }
}