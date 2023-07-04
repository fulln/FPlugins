package com.github.fulln.fplugins.listeners

import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.IdeFrame

internal class MyApplicationActivationListener : ApplicationActivationListener {

    override fun applicationActivated(ideFrame: IdeFrame) {
        val project = ideFrame.project
        // get  Name from project and print log
        thisLogger().warn("project name is ${project?.name}")
    }
}
