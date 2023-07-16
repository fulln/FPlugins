package com.github.fulln.fplugins.toolWindow

import com.github.fulln.fplugins.services.MyProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBPanel

class FPluginsToolWindow(toolWindow: ToolWindow) {

    private val service = toolWindow.project.service<MyProjectService>()

    fun getContent() = JBPanel<JBPanel<*>>().apply {
        val panel = FPluginsPanel()
        add(panel)
    }
}