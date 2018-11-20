package com.buckstabue.kodi.dsl

import com.buckstabue.kodi.core.Component

fun component(parent: Component? = null, definition: ComponentDefinition.() -> Unit): Component {
    val parentDefinition = parent?.componentDefinition?.definitionMap.orEmpty()
    return Component(
        ComponentDefinition(
            parentDefinition.toMutableMap()
        ).apply(definition)
    )
}
