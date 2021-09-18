package com.torrydo.qrme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.torrydo.qrme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.button.setOnClickListener {

            val value = binding!!.edittext.text.toString()

            val multiFormatWriter = MultiFormatWriter()

            try {
                val bitMatrix = multiFormatWriter.encode(
                    value,
                    BarcodeFormat.QR_CODE,
                    500,
                    500
                )
                val barCodeEncoder = BarcodeEncoder()
                val bitmap = barCodeEncoder.createBitmap(bitMatrix);

                binding!!.imageView.setImageBitmap(bitmap)

            } catch (e: Exception) {
                Log.e("ERROR", "catch csdafsd")
            }
        }

    }
}