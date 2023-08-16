package com.example.kotlinpracticeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinpracticeapp.R
import com.example.kotlinpracticeapp.databinding.FragmentSelectionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SelectionFragment : Fragment(), View.OnClickListener{
    lateinit var navController: NavController
    lateinit var binding: FragmentSelectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // 바인딩 초기화
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        // 원래 레이아웃뷰 반환은 밑의 표현식이나 바인딩 사용하므로 바꿔줌
        // return inflater.inflate(R.layout.fragment_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostController = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostController.navController

        binding.btnBack.setOnClickListener(this)
        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_back -> {
                navController.navigate(R.id.action_selectionFragment_to_questionFragment)
            }
            R.id.option_1 -> {
                navigateWithIndex(1)
                navController.navigate(R.id.action_selectionFragment_to_resultFragment1)
            }
            R.id.option_2 -> {
                navigateWithIndex(2)
                navController.navigate(R.id.action_selectionFragment_to_resultFragment2)
            }
            R.id.option_3 -> {
                navigateWithIndex(3)
                navController.navigate(R.id.action_selectionFragment_to_resultFragment3)
            }
            R.id.option_4 -> {
                navigateWithIndex(4)
                navController.navigate(R.id.action_selectionFragment_to_resultFragment4)
            }
        }
    }

    fun navigateWithIndex(index: Int){
        val bundle = Bundle()
        bundle.putInt("index", index)
    }
}