package pract;

public class TableModelResult extends TableModelBase {

    public TableModelResult() {
        super();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return rowIndex;
        if (Alg.d[rowIndex][columnIndex - 1] == Alg.INF)
            return 0;
	return Alg.d[rowIndex][columnIndex - 1];
    }
}
