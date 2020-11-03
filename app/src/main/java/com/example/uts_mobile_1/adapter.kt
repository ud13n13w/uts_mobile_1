package com.example.uts_mobile_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_fakultas.view.*
import kotlinx.android.synthetic.main.profile.view.*

class adapter (private val ds_fakultas:ArrayList<fakultas>) : RecyclerView.Adapter<adapter.holder_fakultas>(){

    //1
    interface OnItemClickCallback{
        fun onItemClicked(data:fakultas)
    }

    //2
    private var onItemClickCallback : OnItemClickCallback? = null

    //3
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.holder_fakultas {
        return holder_fakultas(LayoutInflater.from(parent.context).inflate(R.layout.list_fakultas, parent, false))
    }

    override fun onBindViewHolder(holder: adapter.holder_fakultas, position: Int) {

        //SECTION : Viewholder
        //holder.view_fakultas.tv_namafakultas.text = ds_fakultas.get(position).nama_fakultas
        //holder.view_fakultas.iv_logofakultas.setImageBitmap(ds_fakultas.get(position).gambar_fakultas)

        holder.bind(ds_fakultas[position])

    }

    override fun getItemCount(): Int = ds_fakultas.size

    //5
    inner class holder_fakultas (val view_fakultas: View) : RecyclerView.ViewHolder(view_fakultas){

        fun bind(fakultas_item: fakultas){
            with(view_fakultas){
                tv_namafakultas.text = fakultas_item.nama_fakultas
                fakultas_item.gambar_fakultas?.let { iv_logofakultas.setImageResource(it) }

                itemView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(fakultas_item)
                }
            }
        }

    }


}