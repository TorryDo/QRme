package com.torrydo.qrme.utils

import android.graphics.Bitmap
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder

fun String.toQrBitmap(): Bitmap? {
    return try {

        val qrgEncoder = QRGEncoder(this, null, QRGContents.Type.TEXT, 500)
//        qrgEncoder.colorBlack = Color.RED;
//        qrgEncoder.colorWhite = Color.BLUE;
        qrgEncoder.bitmap
    } catch (e: Exception) {
        null
    }

}

//    return try {
//
////        val map = mapOf(Pair(EncodeHintType.CHARACTER_SET, "utf-8"))
//
//        val bitMatrix = MultiFormatWriter().encode(
//            this,
//            BarcodeFormat.QR_CODE,
//            500,
//            500,
////            map
//        )
//
//        return BarcodeEncoder().createBitmap(bitMatrix)
//
//    } catch (e: Exception) {
//        Log.e("ERROR", e.message.toString())
//
//        null
//    }