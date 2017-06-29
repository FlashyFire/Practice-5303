/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract;
import java.util.HashSet;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
/**
 *
 * @author Asus-PC
 */
public class TableModelInc implements TableModel {
    private HashSet<TableModelListener> listeners = new HashSet<>();
    
    protected TableModelInc()
    {
        
    }
    
    @Override
    public int getRowCount() {
        return SpInc.N;
    }

    @Override
    public int getColumnCount() {
        
        return SpInc.N*2+1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0)
            return "i";
        if (columnIndex%2==0)
            return "w";
        else
            return "j";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==0)
            return false;
        else
            return columnIndex%2==0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return rowIndex ;
        if (columnIndex%2==0)
            return SpInc.L[rowIndex][(columnIndex-1)/2];
        else
            return (columnIndex-1)/2;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        SpInc.L[rowIndex][(columnIndex-1)/2]=Integer.valueOf(aValue.toString());
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
    
}
