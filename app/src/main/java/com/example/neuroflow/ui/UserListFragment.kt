package com.example.neuroflow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neuroflow.InjectorUtils
import com.example.neuroflow.R
import com.example.neuroflow.data.User
import com.example.neuroflow.viewmodel.UserListViewModel

class UserListFragment : Fragment() {

    private lateinit var userListViewModel: UserListViewModel
    private lateinit var femaleUserAdapter: UserAdapter
    private lateinit var maleUserAdapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        val factory = InjectorUtils.provideUserListViewModelFactory(requireActivity())
        userListViewModel = ViewModelProviders.of(requireActivity(), factory).get(UserListViewModel::class.java)

        // female list
        femaleUserAdapter = UserAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView_female).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = femaleUserAdapter
        }
        subscribeUi(userListViewModel.femaleUsers, femaleUserAdapter)

        // male list
        maleUserAdapter = UserAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView_male).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = maleUserAdapter
        }
        subscribeUi(userListViewModel.maleUsers, maleUserAdapter)

        return view
    }

    private fun subscribeUi(femaleUsers: LiveData<List<User>>, adapter: UserAdapter) {
        femaleUsers.observe(viewLifecycleOwner, Observer { users ->
            users?.let { adapter.setCivics(it, object : UserAdapter.OnItemClickListener {
                override fun onItemClick(user: User) {
                    val action = UserListFragmentDirections.nextAction(user.id)
                    findNavController().navigate(action)
                }
            }) }
        })
    }
}