package com.example.kotlinsample

class MyClass {
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
//           Hello World
            println("Hello World")

//            Data type
            Int
            String
            Boolean
            Double
            Float
            Long
            Char
            Byte
            Short

//            Variable Declaration
            var  a : Int = 7
            println("a = $a")
            var name : String = "Manas";
            println("name = $name");

//            val vs var
            // Immutable variable (val)
            val message: String = "Hello, Kotlin!"
            // message = "New Message"          --> This line will cause an error because 'message' is read-only
            println(message)

            // Mutable variable (var)
            var count: Int = 10
            println("Initial count: $count")
            count = 20
            println("Updated count: $count")

//            function declaration
            println("The sum of 5 & 6 is ${add(5,6)}");
            println("The sum of 5 , 6 & 7 is ${add(5,6,7)}");


//            conditional statement
            var msg = ""
            msg = if (a > 5) "no is greater" else "no is smaller"
            println(msg)
            /*if (a > 5){
                println("$a is greater than 5");
            }else
                println("$a is smaller than 5");*/

            // if else if else if else
            if (a >80){

            }else if (a >60){

            }else if (a >40){

            }else{

            }

            // just like switch
            when {
                a >80 -> {

                }
                a >60 -> {

                }
                a >40 -> {

                }
                else -> {

                }
            }
            // or

            when (a){
                7 -> {

                }
                5 -> {

                }
            }


//            Lists in Kotlin
            val aList = listOf("a","b",5,6.58,"d", listOf(1,2,3))   // immutable
            println(aList)

            val mList = mutableListOf<Any>("b",5)
            mList.add(15)
            mList.add("Manas")
            println(mList)
            println()

            val mAlist  = mutableListOf<Any>(95,9562)
            mList.addAll(mAlist)

            mList.add(0,"Abc")
            println(mList)


//            Sets in Kotlin
            val aSet = setOf("a","b",5,6.58,"d")   // immutable
            println(aSet)

            val mSet = mutableSetOf<Any>("b",5)
            mSet.add(15)
            mSet.add("Manas")
            println(mSet)


//            Maps in Kotlin
            val aMap = mapOf(1 to "Manas", 2 to "Rahul","Manas" to "Sanam", true to "check")        // immutable
            println(aMap)

            val mMap = mutableMapOf<Any,Any>()
            val mAMap = mapOf(1 to "a","a" to "b")
            mMap.putAll(mAMap)
            println(mMap)
            mMap[1] = "Raman"
            println(mMap)


//            Array List in Kotlin
            val arrName = ArrayList<String>()
            arrName.add("A")
            arrName.add("B")
            arrName[0] = "Raman"
            println(arrName)
            arrName.remove("B")
            arrName.removeAt(0)
            println(arrName)


//            for loop
            var num = 0;
            /*for (i in 0 .. 10){
                println("Number is : ${num++}")
            }*/
            /*for (i in 0 until  10){
                println("Number is : ${num++}")
            }*/
            /*for(i in 10 downTo 0){
                println("Number is : ${num--}")
            }*/
            /*for(i in 0 .. 10 step 5){
                println("Number is : ${num++}")
            }*/
            val arrNo = arrayListOf(2,5,8,6,4,2)
            arrNo.add(42)
            arrNo.add(422)
            arrNo.add(423)
            arrNo.add(424)
            arrNo.add(425)

//            for-each
            for (i in arrNo){
                println("No is ${i}")
            }

//            while loop
            var n = 5
            while (n < 10){
                println("Num is : $n")
                n++
            }

//            do-while loop
            var no = 5
            do {
                println("N is : $no")
            }while (no <5)


//            Pair
            val (x,y) = Pair("Raman",2)
            println("$x $y")
            val aPair = Pair("Raman",Pair("Ramanujan",Pair("Ramjan",2)))
            println("${aPair.first},${aPair.second.second.first}")


//            Triple
            val (p,q,r) = Triple("Hello","world","Kotlin")
            println("$p, $q, $r")
            val number = Triple("Hello","world",Triple(p,q,Triple(p,q,r)))
            println(number)
            println("${number.third.third.second}")

        }
        fun add(a:Int, b:Int) : Any{
            return  a+b
        }
        fun add(a:Int, b:Int,c:Int) : Any{
            return  a+b+c
        }
    }

}