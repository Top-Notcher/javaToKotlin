package com.advanced.lec08

/** example01 : 인스턴스화 시점과 변수 초기화 시점의 분리
 */
class Person1(
    val name: String,
) {
    val isKim: Boolean
        get() = this.name.startsWith("김")

    val maskingName: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

class Person2 {
    lateinit var name: String

    val isKim: Boolean
        get() = this.name.startsWith("김")

    val maskingName: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

/** example02 : 지연 초기화 1회 로직
 */
class Person3 {
    /** problem01
     * - name을 사용하지 않으면, Thread.sleep()이 호출되지 않지만
     * - name을 쓸 때마다 sleep가 호출된다.
     */
    val name: String
        get() {
            Thread.sleep(2_000)
            return "김수한무"
        }
}

class Person4 {
    /** problem02
     * - Thread.sleep()는 1회만 호출되지만,
     * - name을 사용하지 않는 경우에도 sleep이 호출된다.
     */
    val name: String
    init {
        Thread.sleep(2_000)
        name = "김수한무"
    }
}

class Person5 {
    /** solution01 : backing property
     * - name이 사용되는 경우에만 _name을 초기화하여 Thread.sleep()은 꼭 필요할 때 1회만 호출된다.
     * - 코드 양이 많아진다는 단점이 명확히 존재
     */
    private var _name: String? = null
    val name: String
        get() {
            if (_name == null) {
                Thread.sleep(2_000)
                this._name = "김수한무"
            }
            return this._name!!
        }
}

class Person6 {
    /** solution02 : by lazy 사용!
     */
    val name: String by lazy {
        Thread.sleep(2_000)
        "김수한무"
    }
}