package com.example.myapplicationds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationds.R
import kotlinx.android.synthetic.main.fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext


class Fragment : Fragment(), KodeinAware {

    override val kodeinContext = kcontext<Fragment>(this)
    private val parentKodein: Kodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }
    override val kodeinTrigger: KodeinTrigger?
        get() = super.kodeinTrigger

    private val viewModel: ViewModel by instance()
    private val adapterRV = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kodeinTrigger?.trigger()
        viewModel.getData()

        viewModel.liveDataRemoteProvider.observe(viewLifecycleOwner, Observer {
            adapterRV.addItemsRemote(it)
        })

        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            rv_list.adapter = adapterRV
        }
    }
}