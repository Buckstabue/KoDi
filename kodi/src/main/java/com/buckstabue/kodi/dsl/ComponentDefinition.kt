package com.buckstabue.kodi.dsl

import android.util.Log

class ComponentDefinition(
    val definitionMap: MutableMap<BeanKey, BeanDefinition<*>>
) {

    inline fun <reified T : Any> single(qualifier: Any = DefaultQualifier, noinline factory: () -> T) {
        val beanKey = BeanKey(T::class.java, qualifier)
        definitionMap[beanKey] = BeanDefinition.Single(factory)
    }

    inline fun <reified T : Any> factory(qualifier: Any = DefaultQualifier, noinline factory: () -> T) {
        val beanKey = BeanKey(T::class.java, qualifier)
        definitionMap[beanKey] = BeanDefinition.Factory(factory)
    }

    inline fun <reified T : Any> get(qualifier: Any = DefaultQualifier): T {
        val optional = getOptional<T>(qualifier)
        return if (optional != null) {
            optional
        } else {
            Log.e("ComponentDefinition", "definitionMap=$definitionMap")
            throw IllegalStateException(
                "Could not find a bean with type of ${T::class.java.name} " +
                        "and qualifier ${qualifier::class.java}"
            )
        }
    }

    inline fun <reified T : Any> getOptional(qualifier: Any = DefaultQualifier): T? {
        val beanKey = BeanKey(T::class.java, qualifier)
        val beanDefinition = definitionMap[beanKey] ?: return null
        return beanDefinition.provideDependency() as T
    }
}

object DefaultQualifier
