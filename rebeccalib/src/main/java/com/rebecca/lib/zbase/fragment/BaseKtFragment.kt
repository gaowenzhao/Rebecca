package com.rebecca.lib.zbase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtFragment : Fragment(), ICreate {
				//=========================  =================================
				abstract var mLayoutId: Int
				//=========================  =================================
				val mTag = javaClass.simpleName

				var isDebug = false
				//=========================  =================================
				var mRootView: View? = null

				//=========================  =================================

				abstract fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

				override fun onInit() {
								onInitView()
								onInitData()
				}

				override fun onInitView() {
				}

				override fun onInitData() {
				}

				//=========================main ==================================

				override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
								if (mRootView == null) {
												mRootView = onCreateRootView(inflater, container, savedInstanceState)
								}
								else {
												val parent = mRootView?.getParent() as ViewGroup
												parent.removeView(mRootView)
								}
								return mRootView
				}
}