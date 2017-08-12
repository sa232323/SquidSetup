package com.github.czyzby.setup.views

import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.utils.ObjectMap
import com.badlogic.gdx.utils.ObjectSet
import com.github.czyzby.autumn.annotation.Processor
import com.github.czyzby.autumn.context.Context
import com.github.czyzby.autumn.context.ContextDestroyer
import com.github.czyzby.autumn.context.ContextInitializer
import com.github.czyzby.autumn.processor.AbstractAnnotationProcessor
import com.github.czyzby.lml.annotation.LmlActor
import com.github.czyzby.lml.parser.LmlParser
import com.github.czyzby.setup.data.langs.Language
import com.github.czyzby.setup.data.project.Project
import com.kotcrab.vis.ui.widget.VisTextField

/**
 * Holds additional JVM languages data.
 * @author MJ
 */
@Processor
class LanguagesData : AbstractAnnotationProcessor<JvmLanguage>() {
    private val jvmLanguages = mutableMapOf<String, Language>()

    @LmlActor("\$jvmLanguages") lateinit var languageButtons: ObjectSet<Button>
    val languageVersions = ObjectMap<String, VisTextField>()

    val languages: Array<String>
        get() = jvmLanguages.values.map { it.id }.sorted().toTypedArray()

    val versions: Array<String>
        get() = jvmLanguages.values.sortedBy { it.id }.map { it.version }.toTypedArray()

    fun assignVersions(parser: LmlParser) {
        jvmLanguages.values.forEach {
            languageVersions.put(it.id,
                    parser.actorsMappedByIds.get(it.id + "Version") as VisTextField)
        }
    }

    fun getVersion(id: String): String = languageVersions[id].text

    fun getSelectedLanguages(): List<Language> = languageButtons.filter { it.isChecked }.map {
        jvmLanguages.get(it.name)!!
    }.toList()

    fun appendSelectedLanguagesVersions(project: Project) {
        languageButtons.filter { it.isChecked }.forEach {
            project.properties[it.name + "Version"] = languageVersions.get(it.name).text
        }
    }

    override fun getSupportedAnnotationType(): Class<JvmLanguage> = JvmLanguage::class.java
    override fun isSupportingTypes(): Boolean = true
    override fun processType(type: Class<*>, annotation: JvmLanguage, component: Any, context: Context,
                             initializer: ContextInitializer, contextDestroyer: ContextDestroyer) {
        val language = component as Language
        jvmLanguages[language.id] = language
    }
}

/**
 * Should annotate all additional JVM languages.
 * @author MJ
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JvmLanguage