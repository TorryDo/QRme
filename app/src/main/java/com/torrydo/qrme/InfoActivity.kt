package com.torrydo.qrme

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.torrydo.qrme.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private var binding: ActivityInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        onclick()
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun onclick() {
        binding!!.buttonReturn.setOnClickListener {
            finish()
        }
        binding!!.sendMeEmail.setOnClickListener {
            sendEmail(
                getString(R.string.dev_email),
                getString(R.string.email_title_contact),
                ":3 --- UwU"

            )
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
//            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}

//1 -> {
//                            val addresses = arrayOf(getString(R.string.dev_email))
//                            val subject = getString(R.string.email_title_contact)
//                            val attachment: Uri? = null
//
//                            val intent = Intent(Intent.ACTION_SEND);
//
//                            intent.data = Uri.parse("mailto:");
//                            intent.type = "message/rfc822";
//
////                            intent.type = "*/*";
//                            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//                            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                            intent.putExtra(Intent.EXTRA_STREAM, attachment);
//                            if (intent.resolveActivity(requireActivity().packageManager) != null) {
//                                startActivity(Intent.createChooser(intent, "send Email"));
//                            }
//                        }
//                        2 -> {
//                            val packageName = getString(R.string.package_name)
//                            val uri = Uri.parse("market://details?id=$packageName")
//                            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
//                            try {
//                                startActivity(myAppLinkToMarket)
//                            } catch (e: ActivityNotFoundException) {
//                                MotionToast.createColorToast(
//                                    mActivity,
//                                    "ERROR",
//                                    "Not Available",
//                                    MotionToast.TOAST_ERROR,
//                                    MotionToast.GRAVITY_BOTTOM,
//                                    MotionToast.LONG_DURATION,
//                                    null
//                                )
//                            }
//                        }