package view.jenismember;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.JenisMember;

public class JenisMemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama"};
    private List<JenisMember> data;  // Corrected to JenisMember (capital J)

    // Constructor
    public JenisMemberTableModel(List<JenisMember> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        JenisMember rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0 -> value = rowItem.getNama();
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method to add a new row to the table
    public void add(JenisMember value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);  // Notify the table that a row has been added
    }

    // Method to clear all data
    public void clear() {
        data.clear();
        fireTableDataChanged();  // Notify the table that all data has changed
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public List<JenisMember> getData() {
        return data;
    }

    public void setData(List<JenisMember> data) {
        this.data = data;
    }
}
