package com.example.kotlinpracticeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinpracticeapp.R
import com.example.kotlinpracticeapp.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class MainFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding initialization
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // 원래 레이아웃뷰 반환은 밑의 코드이나 ViewBinding으로 처리
        // return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 뷰가 만들어지고 나서 생성되는 함수
        super.onViewCreated(view, savedInstanceState)
        // navController = Navigation.findNavController(view)
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.btnNext.setOnClickListener{
            //navController 이용해서 action 이동
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }
    }
}