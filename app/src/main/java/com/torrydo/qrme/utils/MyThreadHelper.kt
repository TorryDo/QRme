package com.torrydo.qrme.utils

import android.os.Handler
import android.os.Looper
import com.torrydo.qrme.interfaces.RequestListener

class MyThreadHelper {

    fun startOnMainThread(requestListener: RequestListener) {
        Handler(Looper.getMainLooper()).post {
            requestListener.request()
        }
    }

}