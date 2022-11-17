package com.example.mtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.mtest.databinding.ActivityMainBinding

/*
* Main
*  */

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            viewModel = MainViewModel
            lifecycleOwner = this@MainActivity
        }

        // LiveData의 value의 변경을 감지하고 호출 PageNum이 변경되면 호출
        MainViewModel.currentPageNum.observe(this) {
            // it은 LiveData의 value 값 즉 MainViewModel 객체의 value값이 넘어온다. 처음 선언된 _currentPageNum가 넘어옴
            changeFragment(it)
        }

        setContentView(binding.root)



//        binding.bottomNavigationView.setOnItemSelectedListener  {
//            when (it.itemId) {
//                R.id.home -> {
//                    viewModel.pageData++
//                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
//                    replaceFragment(HomeFragment())
//                }
//                R.id.add -> {
//                    viewModel.pageData++
//                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
//                    replaceFragment(AddFragment())
//                }
//                else -> {
//                    viewModel.pageData++
//                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
//                    replaceFragment(HomeFragment())
//                }
//            }
//        true
//        }

        //setContentView(R.layout.activity_main)
        Log.d("jecesMainActivity1", "onCreate" )
        Log.d("jecesMainActivity1", MainViewModel.pageData.toString() )
    }

    private fun changeFragment(pageNum: PageNum) {
        // 현재 Fragemnt
        var targetFragment = supportFragmentManager.findFragmentByTag(pageNum.tag)
        Log.d("jecesMainActivity1", pageNum.tag)
        // Fragment Ktx의 commit 함수
        supportFragmentManager.commit {
            // 현재 Fragment가 null이라면
            if (targetFragment == null) {
                // getFragment를 호출하여 Fragment 획득
                targetFragment = getFragment(pageNum)
                // 현재 Fragment 추가
                add(R.id.frame_layout, targetFragment!!, pageNum.tag)
            }

            // 현재 Fragment show
            show(targetFragment!!)

            // 나머지 Fragment hide
            PageNum.values()
                .filterNot { it == pageNum }
                .forEach { type ->
                    supportFragmentManager.findFragmentByTag(type.tag)?.let {
                        hide(it)
                    }
                }
        }
    }

    private fun getFragment(pageType: PageNum): Fragment {
        return HomeFragment.newInstance(pageType.title)
    }

    fun replaceFragment(fragment: Fragment){
        Log.d("MainActivity1", "replaceFragment")
        val bundle = Bundle()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }


    override fun onStart() {
        super.onStart()

        Log.d("jecesMainActivity1", "onStart" )
    }

    override fun onResume() {
        super.onResume()

        Log.d("jecesMainActivity1", "onResume" )
    }

    override fun onPause() {
        super.onPause()

        Log.d("jecesMainActivity1", "onPause" )
    }

    override fun onStop() {
        super.onStop()

        Log.d("jecesMainActivity1", "onStop" )
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("jecesMainActivity1", "onDestroy" )
    }
}