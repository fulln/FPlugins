package com.github.fulln.fplugins.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.fulln.fplugins.MyBundle
import com.github.fulln.fplugins.services.MyProjectService
import com.intellij.ui.components.JBBox
import javax.swing.JButton


class FPluginsToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val fPluginsToolWindow = FPluginsToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(fPluginsToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class FPluginsToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<MyProjectService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            var description = JBLabel(MyBundle.message("description"))

            // add jblabel  to panel
            add(description)

            // change line
            add(JBLabel(""))
            // add 下拉框 到 panel
            add(JBLabel(MyBundle.message("selectConfig")))
            //
            val list = listOf("1", "2", "3")
            var jbBox = JBBox.createHorizontalBox()
            // add list  to jbbox
            list.forEach() {
                jbBox.add(JBLabel(it))
            }

            //  下拉框选中后，将选中的值传递给后台

            //  后台根据选中的值，加载对应的配置文件
            //  配置文件中的内容，加载到界面中




                // add button to panel
//           add(JButton(MyBundle.message("loadsConfig")).apply {
//                addActionListener {
//                    description.text = MyBundle.message("randomLabel", service.getRandomNumber())
//                }
//            }





//            add(JButton(MyBundle.message("shuffle")).apply {
//                addActionListener {
//                    label.text = MyBundle.message("randomLabel", service.getRandomNumber())
//                }
//            })
        }
    }
}
