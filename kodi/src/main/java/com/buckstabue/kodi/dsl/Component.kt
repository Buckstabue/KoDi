package com.buckstabue.kodi.dsl

import com.buckstabue.kodi.core.Component

fun component(parent: Component? = null, definition: ComponentDefinition.() -> Unit): Component {
    val definitionMap = parent?.componentDefinition?.definitionMap.orEmpty()
        .plus(ComponentDefinition().apply(definition).definitionMap)
    return Component(ComponentDefinition(definitionMap.toMutableMap()))
}
