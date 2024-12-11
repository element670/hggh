package com.example.assignment.crime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.databinding.ItemBinding


class CrimeAdapter(private var crimes: MutableList<Crime> = mutableListOf()) :
    RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        return CrimeHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = crimes.size

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    fun addItem(crime: Crime) {
        crimes.add(crime)
        notifyItemInserted(crimes.lastIndex)
    }

    fun addItems(crimeList: MutableList<Crime>) {
        crimes.addAll(crimeList)
        notifyItemRangeInserted(crimes.size - crimeList.size, crimeList.size)
    }
}


class CrimeHolder(private val view: ItemBinding) : RecyclerView.ViewHolder(view.root) {
    private var crime: Crime? = null
    fun bind(crime: Crime) {
        this.crime = crime
        view.crimeTitle.text = this.crime?.title
        view.crimeDate.text = this.crime?.date.toString()
    }

}
