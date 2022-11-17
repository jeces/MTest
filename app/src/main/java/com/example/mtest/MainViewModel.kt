package com.example.mtest

import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _currentPageNum = MutableLiveData(PageNum.PAGE2)


    val currentPageNum: LiveData<PageNum>
        get() = _currentPageNum

    fun setCurrentPageNum(item: MenuItem): Boolean {
        val menuItemId = item.itemId
        val pageNum = getPageNume(menuItemId)
        changeCurrentPageNum(pageNum)
        return true
    }

    private fun changeCurrentPageNum(pageNum: PageNum) {
        if(currentPageNum.value == pageNum) return
        _currentPageNum.value = pageNum
    }

    private fun getPageNume(menuItemId: Int): PageNum {
        return when(menuItemId) {
            R.id.home -> {
                Log.d("페이지", "페이지")
                PageNum.PAGE1
            }
            R.id.add -> PageNum.PAGE2
            R.id.message -> PageNum.PAGE3
            R.id.setting -> PageNum.PAGE4
            R.id.logout -> PageNum.PAGE5
            else -> throw IllegalArgumentException("Not found menu item")
        }
    }
    var pageData = 0
}