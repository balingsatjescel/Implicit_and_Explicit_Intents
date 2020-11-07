package com.example.implicitandexplicitintents

import android.content.Intent
import android.content.Intent.ACTION_SET_WALLPAPER
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.addContact).setOnClickListener { insertContact(name = "") }
        findViewById<Button>(R.id.wallpaper).setOnClickListener { setWallpaper() }
        findViewById<Button>(R.id.openGal).setOnClickListener { openGallery() }
        findViewById<Button>(R.id.error1).setOnClickListener { error1() }
        findViewById<Button>(R.id.error2).setOnClickListener { error2() }
    }
    private fun insertContact(name: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun setWallpaper() {
        val intent = Intent(ACTION_SET_WALLPAPER)
        startActivity(intent)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_GALLERY)
        startActivity(intent)
    }

    private fun error1() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.opera")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText( applicationContext, "The intent failed due to Opera Mini App not installed.", Toast.LENGTH_LONG).show()
        }
    }

    private fun error2() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.twitter")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText( applicationContext, "The intent failed due to Twitter App not installed.", Toast.LENGTH_LONG).show()
        }
    }
}
