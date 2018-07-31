package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

abstract class BaseVMActivity<V : ViewDataBinding, VM : ViewModel> : BaseKtActivity() {
    //=========================  =================================
    lateinit var ui: V
    lateinit var vm: VM
    //=========================  =================================

    //=========================  =================================

    //=========================init  =================================
    open fun createVM(modelClass: Class<VM>): VM {
        vm = ViewModelProviders.of(this).get(modelClass)
        return vm
    }

    override fun onInit() {
        ui = DataBindingUtil.setContentView(this, mLayoutId)
        ui.setLifecycleOwner(this)
        super.onInit()
    }

    //=========================main ==================================
}