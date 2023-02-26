package ntn.project.dropdragrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ntn.project.dropdragrecyclerview.databinding.ActivityMainBinding
import ntn.project.dropdragrecyclerview.listener.OnItemDragListener
import ntn.project.dropdragrecyclerview.utils.Logger

class MainActivity : AppCompatActivity(), DefaultAdapter.OnClickDefault {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var adapter: IceCreamAdapter
    lateinit var adapterDefaultAdapter: DefaultAdapter
    private var listSelected: MutableList<IceCream> = mutableListOf()
    val listIceCream = mutableListOf(IceCream("A",5.0F),IceCream("B",10.0F),IceCream("C",15.0F))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        adapter = IceCreamAdapter(listSelected)
        activityMainBinding.rcvList.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        activityMainBinding.rcvList.adapter = adapter

        adapterDefaultAdapter = DefaultAdapter(listIceCream, this)
        activityMainBinding.rcvDefault.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        activityMainBinding.rcvDefault.adapter = adapterDefaultAdapter

        activityMainBinding.checkLogs.setOnClickListener {
            val sb = StringBuilder()
            adapter.dataSet.forEach {
                sb.append(it.name)
            }
            activityMainBinding.logs.text = sb
        }
    }

    override fun onClickItem(position: Int) {
        adapter.addItem(listIceCream[position])
    }
}