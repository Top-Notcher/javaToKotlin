package com.advanced.lec04

import com.advanced.lec03.Cage2
import com.advanced.lec03.Fish
import com.advanced.lec03.GoldFish

fun main() {
    // 상위 타입 변수에 하입 타입 변수 넣기
    val int: Int = 1_000
    val num: Number = int

    // out을 사용해 상위 타입 변수에 하위 타입 변수 넣기
    val goldFishCage: Cage2<GoldFish> = Cage2()
    val fishCage: Cage2<out Fish> = goldFishCage


}