package com.torrydo.qrme.service

import android.app.Service
import android.os.Build
import android.service.quicksettings.TileService
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.torrydo.qrme.utils.Utils
import com.torrydo.qrme.utils.showShortToast
import com.torrydo.qrme.view.FloatingQRView
import android.content.Intent
import com.torrydo.qrme.MainActivity


@RequiresApi(Build.VERSION_CODES.O)
class QrGeneratorService(

) : TileService() {

//    private var floatingQRView : FloatingQRView? = null

    override fun onClick() {
        super.onClick()

//        val windowManager = this.getSystemService(Service.WINDOW_SERVICE) as WindowManager
//
//        if(floatingQRView==null) floatingQRView = FloatingQRView(this.baseContext, windowManager)
//        floatingQRView?.addView()
//
//        this.showShortToast(Utils.getLastestClipboard(this))

        val dialogIntent = Intent(this, MainActivity::class.java)
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(dialogIntent)

    }

}