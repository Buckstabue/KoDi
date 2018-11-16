package com.buckstabue.kodi.dsl

sealed class BeanDefinition<T : Any> {
    abstract fun provideDependency(): T

    class Single<T : Any>(
        private val factory: () -> T
    ) : BeanDefinition<T>() {
        @Volatile
        private var instance: T? = null

        override fun provideDependency(): T {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = factory.invoke()
                    }
                }
            }
            return instance!!
        }
    }

    class Factory<T : Any>(
        private val factory: () -> T
    ) : BeanDefinition<T>() {
        override fun provideDependency(): T {
            return factory.invoke()
        }
    }
}
