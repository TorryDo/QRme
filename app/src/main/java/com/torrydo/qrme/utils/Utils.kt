package com.torrydo.qrme.utils

import android.content.ClipboardManager
import android.content.Context
import android.util.Log

object Utils {

    fun getLastestClipboard(context: Context): String{
//        return try {
            val clipboardManager: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipboard = clipboardManager.primaryClip?.getItemAt(0)?.text.toString()
            return clipboard
//        }catch (e: Exception){
//            Log.e("ERROR", "error floating qrview")
//            "null"
//        }
    }

}