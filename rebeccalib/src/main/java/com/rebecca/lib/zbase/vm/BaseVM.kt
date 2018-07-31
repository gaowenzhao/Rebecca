package com.rebecca.lib.zbase.vm

import android.arch.lifecycle.ViewModel

abstract class BaseVM : ViewModel() {

    //lateinit var bean: B

    open val mTag = javaClass.simpleName

    open var isDebug = false
}