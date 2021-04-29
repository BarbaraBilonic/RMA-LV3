package barbarabilonic.ferit.birdcounter.model

class BirdCounter {
    private var birdCount=0
    private var color=0

     fun getBirdCount():Int=birdCount
     fun seeBird()=birdCount++
    fun getColor():Int=color
    fun setColor(c:Int){
        color=c
    }
    fun resetBirdCount(){birdCount=0}
    fun setBirdCount(count:Int){birdCount=count}


}