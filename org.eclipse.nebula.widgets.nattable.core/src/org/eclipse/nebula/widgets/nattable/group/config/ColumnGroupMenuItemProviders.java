package org.eclipse.nebula.widgets.nattable.group.config;

import org.eclipse.nebula.widgets.nattable.Messages;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.group.command.RemoveColumnGroupCommand;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.nebula.widgets.nattable.ui.menu.IMenuItemProvider;
import org.eclipse.nebula.widgets.nattable.ui.menu.MenuItemProviders;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class ColumnGroupMenuItemProviders {

	public static IMenuItemProvider removeColumnGroupMenuItemProvider() {
		return removeColumnGroupMenuItemProvider(Messages.getString("ColumnGroups.removeColumnGroup")); //$NON-NLS-1$
	}
	
	public static IMenuItemProvider removeColumnGroupMenuItemProvider(final String menuLabel) {
		return new IMenuItemProvider() {

			public void addMenuItem(final NatTable natTable, final Menu popupMenu) {
				MenuItem columnStyleEditor = new MenuItem(popupMenu, SWT.PUSH);
				columnStyleEditor.setText(menuLabel);
				columnStyleEditor.setEnabled(true);

				columnStyleEditor.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						NatEventData natEventData = MenuItemProviders.getNatEventData(e);
						int columnPosition = natEventData.getColumnPosition();
						int columnIndex = natEventData.getNatTable().getColumnIndexByPosition(columnPosition);
						natTable.doCommand(new RemoveColumnGroupCommand(columnIndex));
					}
				});
			}
		};
	}

}
