package com.lucaspo.CursoJava_ProjetoLivros.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModel<T> extends AbstractTableModel {

	private List<T> dataList;
	private String[] columnNames;

	public TableModel(String[] columnNames) {
		this.columnNames = columnNames;
		this.dataList = new ArrayList<>();
	}

	public void setData(List<T> dataList) {
		this.dataList = dataList;
		fireTableDataChanged(); // Notifica a tabela que os dados mudaram
	}

	@Override
	public int getRowCount() {
		return dataList.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			Field field = dataList.get(rowIndex).getClass().getDeclaredField(columnNames[columnIndex]);
			field.setAccessible(true);
			return field.get(dataList.get(rowIndex));
		} catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	public T getObjectAt(int rowIndex) {
		if (rowIndex >= 0 && rowIndex < dataList.size()) {
			return dataList.get(rowIndex);
		} else {
			return null;
		}
	}
	
	public void addRow(T rowData) {
        dataList.add(rowData);
        fireTableRowsInserted(dataList.size() - 1, dataList.size() - 1);
    }
}
