package pract;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableHelper {
    public static void SetUpTable(JTable table, TableModel model) {
        CustomTableCellRenderer renderer = new CustomTableCellRenderer();
        table.setDefaultRenderer(Integer.class, renderer);
        
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.setRowHeight(24);
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(24);
            columnModel.getColumn(i).setWidth(24);
        }   
    }
}
