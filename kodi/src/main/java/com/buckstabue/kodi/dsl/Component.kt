package com.buckstabue.kodi.dsl

fun component(parent: Component? = null, definition: ComponentDefinition.() -> Unit): Component {
    val definitionMap = parent?.definitionMap.orEmpty()
        .plus(ComponentDefinition().apply(definition).definitionMap)
    return Component(definitionMap)
}

class Component(
    val definitionMap: Map<BeanKey, BeanDefinition<*>>
) {
    inline fun <reified T : Any> get(qualifier: Any = DefaultQualifier): T {
        return getOptional(qualifier)
            ?: throw IllegalStateException(
                "Could not find a bean with type of ${T::class.java.name} " +
                        "and qualifier ${qualifier::class.java}"
            )
    }

    inline fun <reified T : Any> getOptional(qualifier: Any = DefaultQualifier): T? {
        val beanKey = BeanKey(T::class.java, qualifier)
        val beanDefinition = definitionMap[beanKey] ?: return null
        return beanDefinition.provideDependency() as T
    }
}
