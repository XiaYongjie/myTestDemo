package com.example.myscrollview

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.custom.BookCommonNavigator
import com.example.custom.BookViewPagerHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_item_temp.view.*
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView


class MainActivity : AppCompatActivity() {
    var dates :ArrayList<String> = arrayListOf("1","2","2","2","2","2","2","2","2","2","2","2","2","2")
    var fragments:ArrayList<Fragment> = ArrayList()
    var views:ArrayList<View>  = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniViewPage()
        initMagicIndicator1()

    }
    private fun initMagicIndicator1() {
        val commonNavigator = BookCommonNavigator(this)
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return dates.size
            }
            override fun getTitleView(context: Context?, index: Int): IPagerTitleView? {
                val commonPagerTitleView = CommonPagerTitleView(context)
                // load custom layout
                val customLayout: View = LayoutInflater.from(context).inflate(R.layout.view_item_temp, null)
                when((index%5).toInt()){
                    0->{
                        customLayout.ll.setBackgroundColor(Color.GREEN)
                    }
                    1->{
                        customLayout.ll.setBackgroundColor(Color.YELLOW)
                    }
                    2->{
                        customLayout.ll.setBackgroundColor(Color.RED)
                    }
                    3->{
                        customLayout.ll.setBackgroundColor(Color.BLUE)
                    }
                    4->{
                        customLayout.ll.setBackgroundColor(Color.WHITE)
                    }
                }
                customLayout.ll.text = "position ${index}"
                views.add(customLayout)
                commonPagerTitleView.setContentView(customLayout)
                commonPagerTitleView.onPagerTitleChangeListener = object :
                    CommonPagerTitleView.OnPagerTitleChangeListener {
                    override fun onSelected(index: Int, totalCount: Int) {

                    }

                    override fun onDeselected(index: Int, totalCount: Int) {

                    }

                    override fun onLeave(
                        index: Int,
                        totalCount: Int,
                        leavePercent: Float,
                        leftToRight: Boolean
                    ) {
                        Log.e("=======","==========getTitleView=onLeave=index:$index===")
                        val view = views[index]
                        view.scaleX = 1.3f + (0.8f - 1.3f) * leavePercent
                        view.scaleY = 1.3f + (0.8f - 1.3f) * leavePercent
                    }

                    override fun onEnter(
                        index: Int,
                        totalCount: Int,
                        enterPercent: Float,
                        leftToRight: Boolean
                    ) {
                        Log.e("=======","==========getTitleView=onEnter=index:$index===")
                        val view = views[index]
                        view.scaleX = 0.8f + (1.3f - 0.8f) * enterPercent
                        view.scaleY = 0.8f + (1.3f - 0.8f) * enterPercent
                    }
                }
                commonPagerTitleView.setOnClickListener { vp.currentItem = dates.size-1-index }
                return commonPagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator? {
                return null
            }
        }
        mg.navigator = commonNavigator
        BookViewPagerHelper.bind(mg, vp,dates.size)
    }
    private fun iniViewPage(){
        for ((index,str) in dates.withIndex()){
            fragments.add(TestFragment.newInstance(position = index))
        }
        vp.adapter = MyVpAdapter(supportFragmentManager,fragments)
        vp.offscreenPageLimit =1
        vp.setCurrentItem(fragments.size-1,true)
    }
}
