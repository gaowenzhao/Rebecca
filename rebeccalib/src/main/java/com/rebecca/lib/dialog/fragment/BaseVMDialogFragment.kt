package com.rebecca.lib.dialog.fragment

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.ICreate

abstract class BaseVMDialogFragment<V : ViewDataBinding, VM : ViewModel> : BaseKtDialogFragment(), ICreate, LifecycleOwner {
    //=========================  =================================
    lateinit var ui: V
    lateinit var vm: VM
    //=========================  =================================
    abstract var mLayoutId: Int

    //=========================  =================================
    open fun createVM(modelClass: Class<VM>): VM {
        vm = ViewModelProviders.of(this).get(modelClass)
        return vm
    }

    //=========================  =================================
    fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ui = DataBindingUtil.inflate(inflater, mLayoutId, container, false)
        ui.setLifecycleOwner(this)
        return ui.root
    }

    //========================= main =================================
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = onCreateRootView(inflater, container, savedInstanceState)

        return mRootView
    }
}