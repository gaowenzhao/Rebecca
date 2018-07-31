package com.rebecca.lib.zbase.fragment

import android.os.Bundle
import android.view.View

abstract class BaseLazyFragment : BaseKtFragment() {
				//=========================  =================================

				//=========================  =================================
				var isLoaded: Boolean = false//false=未加载

				//=========================  =================================
				override fun setUserVisibleHint(isVisibleToUser: Boolean) {
								super.setUserVisibleHint(isVisibleToUser)
								//setUserVisibleHint()有可能在fragment的生命周期外被调用
								if (mRootView == null) {
												return
								}
								onInit()
				}

				override fun onInit() {
								if (isLoaded == false) {
												super.onInit()
												isLoaded = true
								}
				}

				//========================= main ==================================
				override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
								super.onViewCreated(view, savedInstanceState)
								if (userVisibleHint) {//默认为可见,正常加载. 需要懒加载时设置为false 则启动懒加载
												onInit()
								}
				}
}