package com.example.lab6_k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat.inflate

class MainActivity : AppCompatActivity() {
    class Data {
        var photo = 0
        var name: String? = null
    }
    class MyAdapter(data: Array<Data?>, view: Int) :
        BaseAdapter() {
        private val data: Array<com.example.lab6_k.MainActivity.Data?>
        private val view: Int
        init {
            this.data = data
            this.view = view
        }
        override fun getCount(): Int {
            return data.size
        }
        override fun getItem(position: Int): Data? {
            return data[position]
        }
        override fun getItemId(position: Int): Long {
            return 0
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater = LayoutInflater.from(parent!!.context)
            val convertView = layoutInflater.inflate(view,parent,false)
            val name = convertView.findViewById<TextView>(R.id.name)
            name.setText(data[position]?.name)
            val imageView = convertView.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(data[position]?.photo!!)
            return  convertView



        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transNameArray = arrayOf("腳踏車", "機車", "汽車", "巴士")
        val transPhotoIdArray = intArrayOf(R.drawable.trans1, R.drawable.trans2, R.drawable.trans3, R.drawable.trans4)
        val transData: Array<com.example.lab6_k.MainActivity.Data?> = arrayOfNulls<com.example.lab6_k.MainActivity.Data>(transNameArray.size)
        for (i in transData.indices) {
            transData[i] = com.example.lab6_k.MainActivity.Data()
            transData[i]?.name = transNameArray[i]
            transData[i]?.photo = transPhotoIdArray[i]
        }
        val transAdapter = MyAdapter(transData, R.layout.trans_list)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = transAdapter
        val messageArray = arrayOf("訊息1", "訊息2", "訊息3", "訊息4", "訊息5", "訊息6")
        val messageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageArray)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = messageAdapter
        val cubeeNameArray = arrayOf("哭哭", "發抖", "再見", "生氣", "昏倒", "竊笑", "很棒", "你好", "驚嚇", "大笑")
        val cubeePhotoIdArray = intArrayOf(
            R.drawable.cubee1,
            R.drawable.cubee2,
            R.drawable.cubee3,
            R.drawable.cubee4,
            R.drawable.cubee5,
            R.drawable.cubee6,
            R.drawable.cubee7,
            R.drawable.cubee8,
            R.drawable.cubee9,
            R.drawable.cubee10
        )
        val cubeeData: Array<com.example.lab6_k.MainActivity.Data?> =
            arrayOfNulls<com.example.lab6_k.MainActivity.Data>(cubeeNameArray.size)
        for (i in cubeeData.indices) {
            cubeeData[i] = com.example.lab6_k.MainActivity.Data()
            cubeeData[i]?.name = cubeeNameArray[i]
            cubeeData[i]?.photo = cubeePhotoIdArray[i]
        }
        val cubeeAdapter = MyAdapter(cubeeData, R.layout.cubee_list)
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3
    }
}