package model;

import dao.BatchManager;
import dao.PressManager;
import dao.StockManager;
import entity.Batch;
import entity.Press;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author badaroux
 */
public class FreePressTableModel extends AbstractTableModel {

    ArrayList<String> columnName = new ArrayList<>();
    ArrayList<Press> pressList = PressManager.fillBusyPressList();
    ArrayList<Batch> batchList = BatchManager.fillListEndBatch();

    public FreePressTableModel() {
        columnName.add("Presse en cours d'utilisation");
        columnName.add("Lot en cours de production");
    }

    public void launch(Batch batch)
    {
        dao.BatchManager.end(batch);
        pressList.remove(this);
        batchList.remove(batch);

        //TODO MAJ TABLEAU    
    }
    

    
    @Override
    public int getRowCount() {
        return pressList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnName.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = "";
        Press press = pressList.get(rowIndex);
        Batch batch = batchList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                o = press;
                break;
            case 1:
                o = batch;
                break;
        }
        return o;
    }

}
