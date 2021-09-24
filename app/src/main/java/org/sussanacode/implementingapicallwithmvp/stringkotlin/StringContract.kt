package org.sussanacode.implementingapicallwithmvp.stringkotlin

class StringContract {

    interface  IView{
        fun setResultData(str: String)

    }


    interface IPresenter{
        fun getcharacterrepeat(str: String) : Char

    }
}