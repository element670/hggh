package com.example.assignment.crime

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        for(element in 0..50){
            val crime = Crime()
            crime.title = "Crime #${element}"
            crime.isSolved = element % 2 == 0
            crimes += crime
        }
    }
}