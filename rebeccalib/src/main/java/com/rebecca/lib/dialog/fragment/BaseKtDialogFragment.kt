package com.rebecca.lib.dialog.fragment

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtDialogFragment : DialogFragment(), ICreate {
    //=========================  =================================
    val mTag = javaClass.simpleName
    var isDebug = false
    //=========================  =================================
    var mRootView: View? = null

    //=========================  =================================

    //========================= init  =================================
    override fun onInit() {
        onInitView()
        onInitData()
    }

    override fun onInitData() {
    }

    override fun onInitView() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit()
    }
}