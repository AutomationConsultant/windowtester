/*******************************************************************************
 *  Copyright (c) 2012 Google, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Google, Inc. - initial API and implementation
 *******************************************************************************/
package expected;

import com.windowtester.runtime.swt.UITestCaseSWT;
import com.windowtester.runtime.swt.locator.MenuItemLocator;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swt.condition.shell.ShellShowingCondition;
import com.windowtester.runtime.swt.locator.FilteredTreeItemLocator;
import com.windowtester.runtime.swt.locator.ButtonLocator;
import com.windowtester.runtime.swt.condition.shell.ShellDisposedCondition;
import com.windowtester.runtime.swt.locator.TableItemLocator;
import com.windowtester.runtime.swt.locator.eclipse.ViewLocator;

public class testTableDoubleClick extends UITestCaseSWT {

	/**
	 * Main test method.
	 */
	public void testtestTableDoubleClick() throws Exception {
		IUIContext ui = getUI();
		ui.click(new MenuItemLocator("Window/Show View/Other..."));
		ui.wait(new ShellShowingCondition("Show View"));
		ui.click(new FilteredTreeItemLocator("WindowTester Support Sandbox"));
		ui.enterText("+");
		ui.click(new FilteredTreeItemLocator(
				"WindowTester Support Sandbox/Table In A View"));
		ui.click(new ButtonLocator("OK"));
		ui.wait(new ShellDisposedCondition("Show View"));
		ui.click(new TableItemLocator("New item 1", new ViewLocator(
				"TableInAView")));
		ui.click(2, new TableItemLocator("New item 2", new ViewLocator(
				"TableInAView")));
		ui.click(new TableItemLocator("New item 1", new ViewLocator(
				"TableInAView")));
	}

}