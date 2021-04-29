package barbarabilonic.ferit.zad2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import kotlin.random.Random

@Entity(tableName = "inspiringPeople")
data class InspiringPearson(
        @PrimaryKey(autoGenerate = true) var id:Int,
        @ColumnInfo(name ="name")var name:String,
        @ColumnInfo(name ="dateOfBD")var dateBirthDeath:String,
        @ColumnInfo(name ="description")var description:String,
        @ColumnInfo(name ="quote1")var quote1:String,
        @ColumnInfo(name ="quote2")var quote2:String,
        @ColumnInfo(name ="imageURL")var imageUrl:String
) : Serializable




