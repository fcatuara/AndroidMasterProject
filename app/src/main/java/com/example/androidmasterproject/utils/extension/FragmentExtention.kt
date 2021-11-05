package com.example.androidmasterproject.utils.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentManager.addFragment(fragment: Fragment, isReplace:Boolean, isAddToBackStack:Boolean, root:Int){
    beginTransaction().apply {
        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        if (isAddToBackStack) addToBackStack(fragment.javaClass.name)
        if (isReplace) {
            replace(root, fragment)
        } else {
            add(root,fragment)
            show(fragment)
        }
        commit()
    }
}