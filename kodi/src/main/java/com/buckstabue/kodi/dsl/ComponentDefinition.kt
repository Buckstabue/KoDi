package com.buckstabue.kodi.dsl

class ComponentDefinition {
    val definitionMap = mutableMapOf<BeanKey, BeanDefinition<*>>()

    inline fun <reified T : Any> single(qualifier: Any = DefaultQualifier, noinline factory: () -> T) {
        val beanKey = BeanKey(T::class.java, qualifier)
        definitionMap[beanKey] = BeanDefinition.Single(factory)
    }

    inline fun <reified T : Any> factory(qualifier: Any = DefaultQualifier, noinline factory: () -> T) {
        val beanKey = BeanKey(T::class.java, qualifier)
        definitionMap[beanKey] = BeanDefinition.Factory(factory)
    }
}

object DefaultQualifier
