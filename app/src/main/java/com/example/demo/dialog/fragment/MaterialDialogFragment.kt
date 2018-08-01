package com.example.demo.dialog.fragment

import android.view.View
import com.example.demo.R
import com.example.demo.activity.RebeccaClicker
import com.example.demo.databinding.MaterialDialogFragmentBinding
import com.example.demo.dialog.vm.MaterialDialogVM
import com.rebecca.lib.dialog.fragment.BaseVMDialogFragment

class MaterialDialogFragment : BaseVMDialogFragment<MaterialDialogFragmentBinding, MaterialDialogVM>(), RebeccaClicker {
    //=========================  =================================
    var age = 0
    override var mLayoutId: Int = R.layout.material_dialog_fragment
    //=========================  =================================
    override fun onClick(v: View?) {
        when (v) {
            ui.btApply -> {
                age++
                vm.age = age.toString()
                //vm.info.postValue(vm.string)
                //ui.vm = vm
                vm.info.postValue(" age:" + vm.age)
            }
        }
    }
    //=========================  =================================

    override fun createVM(modelClass: Class<MaterialDialogVM>): MaterialDialogVM {
        super.createVM(modelClass)
        vm.title.postValue("自定义标题")
        vm.info.postValue("信息")
        //vm.string = "4654"
        return vm
    }

    override fun onInitView() {
        super.onInitView()
        ui.vm = createVM(MaterialDialogVM::class.java)
        ui.clicker = this
        dialog.setTitle(vm.title.value)
    }
    //========================= main ==================================
}