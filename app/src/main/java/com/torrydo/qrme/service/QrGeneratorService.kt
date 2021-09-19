package com.torrydo.qrme.service

import android.content.Intent
import android.os.Build
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi
import com.torrydo.qrme.MainActivity


@RequiresApi(Build.VERSION_CODES.O)
class QrGeneratorService(

) : TileService() {

    override fun onClick() {
        super.onClick()

        val dialogIntent = Intent(this, MainActivity::class.java)
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(dialogIntent)

    }

}