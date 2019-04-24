package com.example.neuroflow.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neuroflow.R
import com.example.neuroflow.data.User



class UserAdapter : RecyclerView.Adapter<UserAdapter.CivicAddressViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(user: User)
    }

    private var users = emptyList<User>()
    private var listener: OnItemClickListener? = null

    class CivicAddressViewHolder(textView: View) : RecyclerView.ViewHolder(textView) {
        val civicAddressTextView: TextView = textView.findViewById(R.id.textView)

        fun bind(user: User, listener: OnItemClickListener?) {
            civicAddressTextView.text = "${user.name} - ${user.score} - ${user.time}"
            itemView.setOnClickListener { listener?.onItemClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CivicAddressViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item, parent, false)
        return CivicAddressViewHolder(textView)
    }

    override fun onBindViewHolder(holder: CivicAddressViewHolder, position: Int) {
        val current = users[position]
        holder.bind(current, listener)
    }

    override fun getItemCount() = users.size

    internal fun setCivics(users: List<User>, listener: OnItemClickListener) {
        this.users = users
        this.listener = listener
        notifyDataSetChanged()
    }
}