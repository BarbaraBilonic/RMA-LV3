package barbarabilonic.ferit.zad2.persistence

import androidx.room.*
import barbarabilonic.ferit.zad2.model.InspiringPearson

@Dao
interface InspiringPearsonDao {

    @Query("SELECT*FROM inspiringPeople")
    fun getPeople() : List<InspiringPearson>

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    fun addPearson(pearson: InspiringPearson)

    @Delete
    fun removePearson(pearson:InspiringPearson)

    @Update
    fun updatePearson(pearson:InspiringPearson)
}