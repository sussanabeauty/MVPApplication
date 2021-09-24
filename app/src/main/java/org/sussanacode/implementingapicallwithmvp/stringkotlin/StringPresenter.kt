package org.sussanacode.implementingapicallwithmvp.stringkotlin

class StringPresenter (val IView: StringContract.IView): StringContract.IPresenter{


    override fun getcharacterrepeat(str: String): Char {

        val storechar: MutableSet<Char> = HashSet()
        var letter = 0.toChar()
        for (i in 0 until str.length) {
            letter = str[i]
            if (!storechar.add(letter)) {
                return str[i].also { letter = it }
            }
        }
        return letter
    }


}