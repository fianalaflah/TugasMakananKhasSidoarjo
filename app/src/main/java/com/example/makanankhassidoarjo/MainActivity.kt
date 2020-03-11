package com.example.makanankhassidoarjo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = tambahData()
        rv_resep.layoutManager = LinearLayoutManager(this)
        rv_resep.setHasFixedSize(true)
        // Adapter untuk menampilkan item pada recycler view sesuai banyaknya data yang diinputkan
        rv_resep.adapter =
            Adapter_Resep(testData) { resepItem: Data_Resep -> klikResepItem(resepItem) }
    }
    //Ketika klik Resep item menerima parameter resepItem, masuk ke ResepDetailActivity
    private fun klikResepItem(resepItem: Data_Resep) {
        val showDetailActivityIntent = Intent(this, Activity_Detail_Resep::class.java)

        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, resepItem.namaResep)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INDEX, resepItem.bahanResep)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, resepItem.caraResep)
        showDetailActivityIntent.putExtra(Intent.EXTRA_CHOSEN_COMPONENT, resepItem.image)
        //Menjalankan Activity showDetailActivityIntent
        startActivity(showDetailActivityIntent)

    }
}
