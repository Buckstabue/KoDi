package com.buckstabue.kodi.core

import com.buckstabue.kodi.dsl.ComponentDefinition
import com.buckstabue.kodi.dsl.DefaultQualifier

class Component(
    val componentDefinition: ComponentDefinition
) {
    inline fun <reified T : Any> get(qualifier: Any = DefaultQualifier): T {
        return componentDefinition.get(qualifier)
    }

    inline fun <reified T : Any> getOptional(qualifier: Any = DefaultQualifier): T? {
        return componentDefinition.getOptional(qualifier)
    }
}
