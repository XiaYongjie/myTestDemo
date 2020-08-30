package com.example.myscrollview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MyVpAdapter(fm: FragmentManager,var fragments:MutableList<Fragment>):FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int) =fragments[p0]

    override fun getCount() =fragments.size
}