package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listOfFragment = ArrayList<Fragment>()
    private val titleOfFragment=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        listOfFragment.add(FirstFragment())
        listOfFragment.add(SecondFragment())
        listOfFragment.add(ThirdFragment())

        val adapter=MyViewPagerAdapter(this@MainActivity)
        binding.viewPager2.adapter=adapter

        titleOfFragment.add("One")
        titleOfFragment.add("Two")
        titleOfFragment.add("Three")

        TabLayoutMediator(binding.tabLayout,binding.viewPager2){tab,position->
            tab.setText(titleOfFragment[position])
        }.attach()
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = listOfFragment.size
        override fun createFragment(position: Int): Fragment = listOfFragment[position]
    }
}