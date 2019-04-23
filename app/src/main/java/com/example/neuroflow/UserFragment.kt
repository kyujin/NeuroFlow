package com.example.neuroflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.neuroflow.data.UserViewModel
import com.example.neuroflow.databinding.UserFragmentBinding

class UserFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: UserFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.user_fragment, container, false)
        val userViewModel = ViewModelProviders.of(activity!!).get(UserViewModel::class.java)
        binding.viewmodel = userViewModel

        return binding.root
    }
}