package com.example.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.ContactRowBinding

class RecyclerContactAdapter(val context: Context, val arrContact: ArrayList<ContactModel>) :
    RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {

    // ViewHolder class that holds the view elements
    class ViewHolder(val binding: ContactRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val cImage = binding.cImage
        val cName = binding.cName
        val cNumber = binding.cNumber
    }

    // Creating the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the layout for each item
        val binding = ContactRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    // Number of items in the RecyclerView
    override fun getItemCount(): Int {
        return arrContact.size
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set data to the view elements in the ViewHolder
        holder.cImage.setImageResource(arrContact[position].img)
        holder.cName.text = arrContact[position].name
        holder.cNumber.text = arrContact[position].number
    }
}
