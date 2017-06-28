package pract;

public class TableModelGraph extends TableModelBase {

    public TableModelGraph() {
        super();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return rowIndex ;
	return Alg.L[rowIndex][columnIndex - 1];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
	return columnIndex > 0;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return;
        Alg.L[rowIndex][columnIndex - 1] = Integer.valueOf(value.toString());
    }
}
