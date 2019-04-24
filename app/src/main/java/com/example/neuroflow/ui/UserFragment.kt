package com.example.neuroflow.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.neuroflow.InjectorUtils
import com.example.neuroflow.R
import com.example.neuroflow.viewmodel.UserViewModel
import com.example.neuroflow.databinding.UserFragmentBinding

class UserFragment : Fragment() {

    private val TAG = UserFragment::class.java.simpleName
    private val args: UserFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "user id: ${args.userId}")
        val factory = InjectorUtils.provideUserViewModelFactory(requireActivity(), args.userId)
        val userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)

        val binding: UserFragmentBinding = DataBindingUtil.inflate<UserFragmentBinding>(inflater,
            R.layout.user_fragment, container, false).apply {
            setLifecycleOwner(this@UserFragment)
        }

        binding.viewmodel = userViewModel

        return binding.root
    }


}