package Util

import android.content.Context
import android.content.Intent
import java.util.Objects

class Util {
    companion object {
        fun openActivity(context: Context, objClass: Class<>){
            val intent = Intent(context, cls = objClass)
            context.startActivity(intent)
        }
    }
}
