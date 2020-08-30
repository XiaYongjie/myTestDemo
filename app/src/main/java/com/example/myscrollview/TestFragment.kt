package com.example.myscrollview

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_test.*
import net.lucode.hackware.magicindicator.buildins.UIUtil
import kotlin.random.Random

class TestFragment : Fragment() {
    var arrays:ArrayList<String> = ArrayList()
    var mAdapter:MyAdapter? = null
    var position:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
           position = it.getInt("position",0)
        }

        savedInstanceState?.let {
            arrays = it.getStringArrayList("arrays")?:ArrayList()
        }
        if (arrays.size==0){
            for (i in 0..20){
                arrays.add("")
            }
        }
        mAdapter=MyAdapter(context!!,arrays)
        rv.apply {
            adapter =mAdapter
            layoutManager =LinearLayoutManager(context)
        }
        rv.isNestedScrollingEnabled = false
        ns.post {
            ns.scrollBy(0,UIUtil.dip2px(context, (120*8).toDouble()))
        }

        test_tv.text = "position ${position}"
        when((Random.nextInt(0,5)%5).toInt()){
            0->{
                cl.setBackgroundColor(Color.GREEN)
            }
            1->{
                cl.setBackgroundColor(Color.YELLOW)
            }
            2->{
                cl.setBackgroundColor(Color.RED)
            }
            3->{
                cl.setBackgroundColor(Color.BLUE)
            }
            4->{
                cl.setBackgroundColor(Color.WHITE)
            }
        }
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("hidden","hidden: "+hidden)

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("arrays",arrays)
    }
    companion object{
        fun newInstance(position:Int) =TestFragment().apply {
            arguments =Bundle().apply {
                putInt("position",position)
            }
        }
    }
}