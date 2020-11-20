package com.example.myapplicationds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationds.R
import com.example.myapplicationds.data.remote.RemoteDataStore
import com.example.myapplicationds.data.remote.RemoteRepository
import com.example.myapplicationds.data.remote.model.ResponseData
import com.example.myapplicationds.domain.DataUseCase
import kotlinx.android.synthetic.main.fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class Fragment : Fragment(), IContract.IView, KodeinAware {

    override val kodeinContext = kcontext<Fragment>(this)
    private val parentKodein: Kodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }

    override val kodeinTrigger: KodeinTrigger?
        get() = super.kodeinTrigger

    private val presenter: IContract.IPresenter by instance()
    private val adapterRV = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        kodeinTrigger?.trigger()
        return inflater.inflate(R.layout.fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            rv_list.adapter = adapterRV
        }

        presenter.getData()
    }

    override fun showData(list: List<ResponseData>) {
        adapterRV.addItems(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}