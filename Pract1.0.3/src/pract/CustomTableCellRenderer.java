package pract;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private final Color firstColumnColor = new Color(0xdd, 0xdd, 0xdd);
    private final Color firstColumnOddRowColor = new Color(0xd0, 0xd0, 0xd0);
    private final Color oddRowColor = new Color(0xf0, 0xf0, 0xf0);
    
    public CustomTableCellRenderer() {
        super();
        super.setHorizontalAlignment(javax.swing.JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0)
            super.setBackground(row % 2 == 1 ? firstColumnOddRowColor : firstColumnColor);
        else
            super.setBackground(row % 2 == 1 ? oddRowColor : Color.white);
        super.setForeground(Color.black);
        
        return result;
    }
}
