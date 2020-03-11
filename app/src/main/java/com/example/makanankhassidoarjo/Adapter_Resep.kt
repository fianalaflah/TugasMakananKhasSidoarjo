package com.example.makanankhassidoarjo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_resep_makanan.view.*

class Adapter_Resep(
    private val resepItemList: List<Data_Resep>,
    private val clickListener: (Data_Resep) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Fungsi CreateViewHolder sesuai data yang ada pada List<Data_Resep>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_resep_makanan, parent, false)
        return PartViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(resepItemList[position], clickListener)
    }

    override fun getItemCount() = resepItemList.size

    //Class PartViewHolder untuk mengubah Atribut komponen sesuai data yang ada pada List<Data_Resep>
    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(resep: Data_Resep, clickListener: (Data_Resep) -> Unit) {
            itemView.tv_nama.text = resep.namaResep
            itemView.tv_caption.text = resep.captionResep
            itemView.imgMakanan.setImageResource(resep.image)
            itemView.imgMakanan.contentDescription = resep.namaResep
            itemView.setOnClickListener { clickListener(resep) }
        }
    }
}

