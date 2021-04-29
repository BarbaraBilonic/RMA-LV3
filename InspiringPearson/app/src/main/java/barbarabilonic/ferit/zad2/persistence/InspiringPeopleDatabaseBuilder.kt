package barbarabilonic.ferit.zad2.persistence

import androidx.room.Room
import androidx.room.RoomDatabase
import barbarabilonic.ferit.zad2.InspiringPeople

object InspiringPeopleDatabaseBuilder {
    private var instance: InspiringPeopleDatabase?=null

    fun getInstance():InspiringPeopleDatabase{
        synchronized(InspiringPeopleDatabase::class){
            if(instance==null){
                instance=buildDatabase()
                addInitialItems()

            }
        }
        return instance!!
    }

    private fun buildDatabase(): InspiringPeopleDatabase {
        return Room.databaseBuilder(
            InspiringPeople.application, InspiringPeopleDatabase::class.java, InspiringPeopleDatabase.NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    private fun addInitialItems(){
        val people=PeopleRepository.getPeople()

            for (pearson in people) {
                instance?.inspiringPearsonDao()?.addPearson(pearson)
            }

    }
}