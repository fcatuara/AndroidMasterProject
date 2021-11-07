package com.example.androidmasterproject.utils.extension

import android.view.View
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


fun View.isVisible(condition: Boolean) {
    visibility = if (condition) {
        View.VISIBLE
    } else {
        View.GONE
    }
}