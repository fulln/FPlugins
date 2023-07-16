// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.fulln.fplugins.toolWindow

import com.github.fulln.fplugins.MyBundle
import com.intellij.ui.components.JBPanel
import com.intellij.ui.dsl.builder.*

fun FPluginsPanel(): JBPanel<*> {

  return panel {
    row(MyBundle.message("inputSome")) {
      label("This text is aligned with next row")
      textField()
    }

    row("Row2:") {
      label("This text is aligned with previous row")
    }

    row("Row3:") {
      label("Rows 3 and 4 are in common parent grid")
      textField()
    }.layout(RowLayout.PARENT_GRID)

    row("Row4:") {
      textField()
      label("Rows 3 and 4 are in common parent grid")
    }.layout(RowLayout.PARENT_GRID)

  }
}