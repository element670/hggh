package com.example.assignment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment

class MyFragment: Fragment()
{
    companion object{
        fun newInstance():MyFragment{
            return MyFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.add(R.string.title_1)
        menu.add(R.string.title_2)
        super.onCreateOptionsMenu(menu, inflater)
    }
}