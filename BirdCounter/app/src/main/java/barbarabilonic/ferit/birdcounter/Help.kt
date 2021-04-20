package barbarabilonic.ferit.birdcounter

import android.graphics.drawable.Drawable

fun getBorderResource(color:Int):Int{
    return  when(color) {
        1 -> R.drawable.border_brown
        2->R.drawable.border_grey
        3->R.drawable.border_black
        4->R.drawable.border_yellow
        else->R.drawable.border_white
    }
}