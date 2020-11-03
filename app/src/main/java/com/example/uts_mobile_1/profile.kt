package com.example.uts_mobile_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.profile.*

class profile : AppCompatActivity() {

    companion object{
        const val DESC_DATA = "desc_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val bundle : Bundle? = intent.getBundleExtra(DESC_DATA)
        val judul = bundle?.getString("judul")
        val desk1 = bundle?.getString("desk1")
        val desk2 = bundle?.getString("desk2")
        val gambar = bundle?.getInt("gambar")

        tv_judulprofile.text = judul.toString()
        tv_deskripsi1.text = desk1.toString()
        tv_deskripsi2.text = desk2.toString()
        gambar?.let { iv_gambarprofile.setImageResource(it) }

    }

}

