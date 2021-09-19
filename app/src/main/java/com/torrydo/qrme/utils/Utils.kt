package com.torrydo.qrme.utils

import android.content.ClipboardManager
import android.content.Context
import android.util.Log

object Utils {

    fun getLastestClipboard(context: Context): String{
            val clipboardManager: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            return clipboardManager.primaryClip?.getItemAt(0)?.text.toString()

    }

}