package com.example.drugizadatak

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.drugizadatak.Fragments.FragmentAddNew
import com.example.drugizadatak.Fragments.FragmentInspiringPerson

class HandsomeAdapter(fragmentManager: androidx.fragment.app.FragmentManager) :  FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragments = arrayOf(
        FragmentInspiringPerson.newInstance(),
        FragmentAddNew.newInstance()
    )
    val titles = arrayOf("Inspiring person", "Add new ")
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
    override fun getCount(): Int {
        return fragments.size
    }

}