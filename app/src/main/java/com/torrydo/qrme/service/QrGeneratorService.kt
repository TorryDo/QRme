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

@RequiresApi(Build.VERSION_CODES.N)
class QrGeneratorService(

) : TileService() {

    private var floatingQRView : FloatingQRView? = null

    override fun onClick() {
        super.onClick()

        val windowManager = this.getSystemService(Service.WINDOW_SERVICE) as WindowManager

        if(floatingQRView==null) floatingQRView = FloatingQRView(this, windowManager)
        floatingQRView?.addView()

        this.showShortToast(Utils.getLastestClipboard(this))

    }

}