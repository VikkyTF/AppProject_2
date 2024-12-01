package com.semenkina.mainapp;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup;
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView;
class PhonesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var mPhonesList: ArrayList<PhoneModel> = ArrayList()
    /*Нам нужно указать идентификатор макета для отдельного элемента списка,
    созданный нами ранее в файле recyclerview_item.xml. А также вернуть наш объект
    класса ViewHolder. Допустим, устройство может отобразить на экране 9 элементов списка.
    RecyclerView создаст 11-12 элементов (с запасом). Неважно, каким большим будет ваш список,
    но все данные будут размещаться в тех же 11 элементах, автоматически меняя содержимое при прокрутке.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item,parent,false)
        return PhonesViewHolder(itemView)
    }
    /*Нам нужно указать идентификатор макета для отдельного элемента списка, созданный
    нами ранее в файле recyclerview_item.xml. А также вернуть наш объект класса ViewHolder.
    Допустим, устройство может отобразить на экране 9 элементов списка. RecyclerView
    создаст 11-12 элементов (с запасом). Неважно, каким большим будет ваш список, но все
    данные будут размещаться в тех же 11 элементах, автоматически меняя содержимое при прокрутке.*/
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        if(holder is PhonesViewHolder){
            holder.bind(mPhones = mPhonesList[position])
        }
    }
    /*Возвращает количество элементов списка.
    Как правило данные являются однотипными, например, список или массив строк.
    Адаптеру нужно знать, сколько элементов нужно предоставить компоненту,
    чтобы распределить ресурсы и подготовиться к отображению на экране.
    При работе с коллекциями или массивом мы можем просто вычислить его длину и
    передать это значение методу адаптера getItemCount()*/
    override fun getItemCount(): Int
    {
        return mPhonesList.count()
    }
    fun setupPhones(phonesList: Array<PhoneModel>){
        mPhonesList.clear()
        mPhonesList.addAll(phonesList)
        notifyDataSetChanged()
    }
    /*Добавим следующий класс в адаптер, в котором описывается связь между моделью и
    полями в recyclerview_item.xml*/
    class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val tv_phone_name: TextView = itemView.findViewById(R.id.tv_phone_name)
        private val tv_price: TextView = itemView.findViewById(R.id.tv_price)
        private val tv_date: TextView = itemView.findViewById(R.id.tv_date)
        private val tv_score: TextView = itemView.findViewById(R.id.tv_score)
        fun bind(mPhones: PhoneModel){
            tv_phone_name.text= mPhones.name
            tv_price.text = mPhones.price
            tv_date.text = mPhones.date
            tv_score.text = mPhones.score
        }
    }
}
