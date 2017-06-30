package pract;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableHelper {
    private static final int CELL_SIZE = 24;
    
    public static void SetUpTable(JTable table, TableModel model) {
        CustomTableCellRenderer renderer = new CustomTableCellRenderer();
        table.setDefaultRenderer(Integer.class, renderer);
        
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.setRowHeight(CELL_SIZE);
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(CELL_SIZE);
            columnModel.getColumn(i).setWidth(CELL_SIZE);
        }   
    }
}
