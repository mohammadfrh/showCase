package com.mohammad.showcase.callback

import java.io.Serializable

interface ShowCaseCallBack :Serializable{
   fun onNextItemClick()
   fun onLastItemClick()
}