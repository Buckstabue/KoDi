package com.buckstabue.kodi.core

class ComponentProvider(
    private val fabric: () -> Component
) {

    @Volatile
    private var component: Component? = null

    fun provideComponent(): Component {
        val tempComponent1 = component
        if (tempComponent1 != null) {
            return tempComponent1
        }
        synchronized(this) {
            // TODO can we use contracts to improve readability
            val tempComponent2 = component ?: fabric.invoke()
            component = tempComponent2
            return tempComponent2
        }
    }

    fun resetComponent() {
        synchronized(this) {
            component = null
        }
    }
}
