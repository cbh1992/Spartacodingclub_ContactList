package com.android.rearguardprojectone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.rearguardprojectone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 해당 전화번호는 모두 난수생성기로 만들어졌습니다
        val dataList = mutableListOf<Item>()
        dataList.add(Item(R.drawable.sample_0, "Alpha", "010-2687-2889",false))
        dataList.add(Item(R.drawable.sample_1, "Beta", "010-3438-3224",false))
        dataList.add(Item(R.drawable.sample_2, "Gamma", "010-9581-1163",false))
        dataList.add(Item(R.drawable.sample_3, "Delta", "010-0861-4862",false))
        dataList.add(Item(R.drawable.sample_4, "Zeta", "010-2413-4148",false))
        dataList.add(Item(R.drawable.sample_5, "eta", "010-3194-2649",false))
        dataList.add(Item(R.drawable.sample_6, "theta", "010-1340-1747",false))
        dataList.add(Item(R.drawable.sample_7, "iota", "010-8490-9040",false))
        dataList.add(Item(R.drawable.sample_8, "kappa", "010-7743-1708",false))
        dataList.add(Item(R.drawable.sample_9, "lambda", "010-9717-6581",false))
        dataList.add(Item(R.drawable.sample_10, "tau", "010-8059-8210",false))
        dataList.add(Item(R.drawable.sample_11, "phi", "010-6519-5152",false))
        dataList.add(Item(R.drawable.sample_12, "chi", "010-6075-7374",false))



        binding.recyclerView.adapter = Adapter(dataList)

        val adapter = Adapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name : String = dataList[position].aName
                val number: String = dataList[position].aNumber
                val starfiled : Boolean = dataList[position].aFavorit
                Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
                startActivity(Intent("android.intent.action.DIAL", Uri.parse("tel:$number")))
            }
        }
    }
}