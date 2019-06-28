package com.manoj.recyclermultiview.adapter

import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manoj.recyclermultiview.constants.AppConstants
import com.manoj.recyclermultiview.R
import com.manoj.recyclermultiview.listeners.RecyclerViewClickListener
import com.manoj.recyclermultiview.models.ClassMember
import kotlinx.android.synthetic.main.item_class_members.view.*

class MainListAdapter(private val customList: MutableList<ClassMember>,private val clickListener: RecyclerViewClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            AppConstants.ViewType.NORMAL -> {
                (holder as CustomViewHolder).bindView()
            }
            AppConstants.ViewType.HEADER -> {
                (holder as HeaderViewHolder).bindView()
            }
            AppConstants.ViewType.FOOTER -> {
                (holder as FooterViewHolder).bindView()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            AppConstants.ViewType.NORMAL -> {
                return CustomViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_class_members,
                        parent,
                        false
                    )
                )
            }
            AppConstants.ViewType.HEADER -> {
                return HeaderViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_class_headers,
                        parent,
                        false
                    )
                )
            }
            else
            -> {
                return FooterViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_class_footer,
                        parent,
                        false
                    )
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return customList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (customList[position].layoutType == AppConstants.ViewType.HEADER)
            return AppConstants.ViewType.HEADER
        else if (customList[position].layoutType == AppConstants.ViewType.FOOTER)
            return AppConstants.ViewType.FOOTER
        else{
            return AppConstants.ViewType.NORMAL
        }
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() {
            itemView.v_list_bullet.text = Html.fromHtml(itemView.context.getString(R.string.bullet))
            itemView.v_list_bullet.setTextColor(getRandomMaterialColour())
            itemView.tv_name.text = customList[adapterPosition].name

        }

        private fun getRandomMaterialColour(): Int {
            itemView.context?.let {
                val arrayID = it.resources.getIdentifier("mdcolor_400", "array", it.packageName)
                val colours = it.resources.obtainTypedArray(arrayID)
                val index = Math.random() * colours.length()
                val resultColour = colours.getIndex(index.toInt())
                colours.recycle()
                return resultColour
            }
            return Color.RED
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() {
            itemView.tv_name.text = customList[adapterPosition].name
        }
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView() {
            itemView.tv_name.text = customList[adapterPosition].name
            itemView.setOnClickListener {
                clickListener.onItemClickListener(adapterPosition)
            }

        }
    }
}