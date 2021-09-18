package com.torrydo.qrme.utils

import android.graphics.Bitmap
import android.util.Log
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder

fun String.toQrBitmap(): Bitmap? {

    return try {
        val bitMatrix = MultiFormatWriter().encode(
            this,
            BarcodeFormat.QR_CODE,
            500,
            500
        )

        return BarcodeEncoder().createBitmap(bitMatrix)

    } catch (e: Exception) {
        Log.e("ERROR", e.message.toString())

        null
    }
}