package com.example.myapplicationds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplicationds.R
import com.example.myapplicationds.data.local.model.LocalData
import kotlinx.android.synthetic.main.fragment_detail.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class FragmentDetail : Fragment(), KodeinAware {

    override val kodeinContext = kcontext<Fragment>(this)
    private val parentKodein: Kodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }
    override val kodeinTrigger = KodeinTrigger()

    private val viewModel: ViewModel by instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kodeinTrigger.trigger()

//        viewModel.liveDataRemoteProvider.observe(viewLifecycleOwner, Observer {
//            val data = viewModel.passDataToFragmentDetail(LocalData(title = "", body = "", id = 0))
//        })

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}