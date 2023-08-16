package com.example.kotlinpracticeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinpracticeapp.R
import com.example.kotlinpracticeapp.databinding.FragmentResult4Binding

/**
 * A simple [Fragment] subclass.
 * Use the [FinalResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class FinalResultFragment : Fragment(){

    var option = -1
    lateinit var navController: NavController
    lateinit var binding: FragmentResult4Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        option = arguments?.getInt("index") ?: -1 // 만약 null 이 전달되면 -1

        // 바인딩 초기화
        binding = FragmentResult4Binding.inflate(inflater, container, false)
        // 원래 레이아웃뷰 반환은 밑의 표현식이나 바인딩 사용하므로 바꿔줌
        // return inflater.inflate(R.layout.fragment_question, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostController = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostController.navController

        binding.btnHome.setOnClickListener {
            navController.navigate(R.id.action_FinalresultFragment_to_mainFragment)
        }

        binding.btnBack.setOnClickListener {
            navController.navigate(R.id.action_resultFragment4_to_selectionFragment)
        }
    }
}