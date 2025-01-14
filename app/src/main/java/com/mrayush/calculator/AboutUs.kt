package com.mrayush.calculator

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element
import kotlinx.android.synthetic.main.about_us.*
import java.util.*

class AboutUs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_us)
        val adsElement = Element()
        val aboutPage: View = AboutPage(this)
            .isRTL(false)
            .setCustomFont("museo.ttf")
            .setImage(R.mipmap.ic_launcher)
            .setDescription(getString(R.string.appDescription))
            .addItem(Element().setTitle("Current Version : "+getString(R.string.appVersion)).setGravity(Gravity.CENTER).setOnClickListener(View.OnClickListener {
                Toast.makeText(
                    this@AboutUs,
                    "Current version of App is : "+getString(R.string.appVersion),
                    Toast.LENGTH_LONG
                ).show()
            }))
            .addGroup("CONNECT WITH US!")
            .addEmail("mrayushcontact@gmail.com")
            .addWebsite("https://calculator.mrayush.me")
            .addYoutube("UCxFLhp74KkKk-l9gw1_ggcQ") //Enter your youtube link here (replace with my channel link)
            .addPlayStore(getPackageName()) //Replace all this with your package name
            .addInstagram("AyushAgnihotri2025") //Your instagram id
            .addItem(createCopyright())
            .create()
        setContentView(aboutPage)
    }

    private fun createCopyright(): Element {
        val copyright = Element()
        @SuppressLint("DefaultLocale") val copyrightString = String.format(
            "Copyright %d by Ayush Agnihotri",
            Calendar.getInstance()[Calendar.YEAR]
        )
        copyright.setTitle(copyrightString)
        copyright.setIconDrawable(R.drawable.ic_copyright);
        copyright.setGravity(Gravity.CENTER)
        copyright.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this@AboutUs,
                copyrightString,
                Toast.LENGTH_SHORT
            ).show()
        })
        return copyright
    }
}