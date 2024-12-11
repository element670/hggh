package com.example.assignment.crime

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.databinding.CrimesFragmentBinding

class CrimeListFragment : Fragment() {
    private var recycleView: RecyclerView? = null
    private var crimeListViewModel: CrimeListViewModel? = null
    private val crimeAdapter: CrimeAdapter = CrimeAdapter()
    private var binding: CrimesFragmentBinding ?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        crimeListViewModel = ViewModelProvider(this)[(CrimeListViewModel::class.java)]
        binding=CrimesFragmentBinding.inflate(layoutInflater)
        Log.d("AAA", "${crimeListViewModel?.crimes?.size}")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.crime_menu, menu)
    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.crimes_fragment,
            container,
            false
        )//convert all xml object to widgets
        recycleView = view.findViewById(R.id.recycler_view)// find recycle in our layout
        recycleView?.layoutManager = LinearLayoutManager(context)
        updateUI()

        return view
    }

    private fun updateUI() {
        val crimes = crimeListViewModel?.crimes
        crimeAdapter.addItems(crimes!!)
        recycleView?.adapter = crimeAdapter
    }


}