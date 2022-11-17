package com.example.mtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mtest.databinding.ActivityMainBinding

/*
* Main
*  */

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.bottomNavigationView.setOnItemSelectedListener  {
            when (it.itemId) {
                R.id.home -> {
                    viewModel.pageData++
                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
                    replaceFragment(HomeFragment())
                }
                R.id.add -> {
                    viewModel.pageData++
                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
                    replaceFragment(AddFragment())
                }
                else -> {
                    viewModel.pageData++
                    Log.d("jecesMainActivity1", viewModel.pageData.toString() )
                    replaceFragment(HomeFragment())
                }
            }
        true
        }

        //setContentView(R.layout.activity_main)
        Log.d("jecesMainActivity1", "onCreate" )
        Log.d("jecesMainActivity1", viewModel.pageData.toString() )
    }

    fun replaceFragment(fragment: Fragment){
//        Log.d("MainActivity1", "replaceFragment")
//        val bundle = Bundle()
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragment.arguments = bundle
//        fragmentTransaction.replace(R.id.frame_layout, fragment)
//        fragmentTransaction.commit()

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
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