package com.example.uts_mobile_1

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val list_fakultas = ArrayList<fakultas>()

    //SECTION : RAW DATA
    val list_namafakultas = arrayOf("FAKULTAS ILMU KOMPUTER", "FAKULTAS TEKNIK", "FAKULTAS EKONOMI DAN BISNIS", "FAKULTAS PERTANIAN", "MUHAMMAD BURHANUDDIN FAWWAZ")
    val list_gambarbarang = intArrayOf(R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.burhan)

    val list_deskripsi1 = arrayOf(
                "Fakultas Ilmu Komputer merupakan salah satu dari 7 Fakultas di UPN Veteran Jawa Timur. Yang teridiri dari program studi:",
                "Fakultas Teknik merupakan salah satu dari 7 Fakultas di UPN Veteran Jawa Timur. Yang teridiri dari program studi:",
                "Fakultas Ekonomi dan Bisnis merupakan salah satu dari 7 Fakultas di UPN Veteran Jawa Timur. Yang teridiri dari program studi:",
                "Fakultas Pertanian merupakan salah satu dari 7 Fakultas di UPN Veteran Jawa Timur. Yang teridiri dari program studi:",
                "Perkenalkan saya Muhammad Burhanuddin Fawwaz NPM 18082010011 Mahasiswa Jurusan Sistem Informasi. Hobi saya adalah:")

    val list_deskripsi2 = arrayOf(
                "1. Teknik Informatika\n2. Sistem Informasi",
                "1. Teknik Kimia\n2. Teknik Industri\n3. Teknik Sipil\n4. Teknik Lingkungan\n 5. Teknologi Pangan",
                "1. Ekonomi Pembangunan\n2. Akuntansi\n 3. Manajemen",
                "1. Agroteknologi\n2. Agribisnis",
                "1. Bermain\n 2. Belajar\n 3. Mengaji")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_fakultas = findViewById<RecyclerView>(R.id.recycler_fakultas)
        recycler_fakultas.setHasFixedSize(true)
        recycler_fakultas.layoutManager = LinearLayoutManager(this)

        //SECTION : INPUT DATA
        for(i in 0 until list_namafakultas.size){

            list_fakultas.add(fakultas(list_namafakultas[i], list_gambarbarang[i], list_deskripsi1[i], list_deskripsi2[i]    ))

            if(list_namafakultas.size - 1 == i){
                val adapter = adapter(list_fakultas)
                adapter.notifyDataSetChanged()
                recycler_fakultas.adapter = adapter

                adapter.setOnItemClickCallback(object : adapter.OnItemClickCallback{
                    override fun onItemClicked(data: fakultas) {
                        val bundle = Bundle()
                        data.gambar_fakultas?.let { bundle.putInt("gambar", it) }
                        bundle.putString("judul", data.nama_fakultas)
                        bundle.putString("desk1", data.deskripsi1_fakultas)
                        bundle.putString("desk2", data.deskripsi2_fakultas)

                        val description = Intent(this@MainActivity, profile::class.java)
                        description.putExtra(profile.DESC_DATA, bundle)
                        startActivity(description)
                    }
                })
            }

        }

    }
}