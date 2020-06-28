package com.github.czyzby.setup.prefs

import com.github.czyzby.autumn.mvc.stereotype.preference.Property

/**
 * Saves GWT framework version. This setting is likely to be the same for multiple projects.
 * @author MJ
 */
@Property("GwtVersion")
class GwtVersionPreference : AbstractStringPreference() {
    override fun getDefault(): String = "2.9.0"
}
