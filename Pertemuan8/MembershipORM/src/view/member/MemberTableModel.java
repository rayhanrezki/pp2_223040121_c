package view.member;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Member;

public class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Jenis Member"};
    private List<Member> data;

    public MemberTableModel(List<Member> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (row < 0 || row >= data.size()) {
            return null;  // Return null if row index is out of bounds
        }
        Member rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getName();
                break;
            case 1:
                value = (rowItem.getJenisMember() != null) ? rowItem.getJenisMember().getNama() : "No Jenis Member";
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;  // Cells are not editable
    }

    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1); // Update table after adding new row
    }

    public void clear() {
        data.clear();
        fireTableDataChanged();  // Refresh the table
    }
}
