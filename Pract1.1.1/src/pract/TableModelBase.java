package pract;

import java.util.HashSet;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public abstract class TableModelBase implements TableModel {
    private HashSet<TableModelListener> listeners = new HashSet<>();

    protected TableModelBase() {
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
	listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
	listeners.remove(listener);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	return Integer.class;
    }

    @Override
    public int getColumnCount() {
	return Alg.N + 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0)
            return "";
        Integer id = columnIndex-1;
        return id.toString();
    }

    @Override
    public int getRowCount() {
	return Alg.N;
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    }
}
