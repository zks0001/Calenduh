/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;
import backend.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.Box.*;
import java.awt.Dimension;
import java.time.*;

/**
 *
 * @author Elise
 */
public class Itenerary extends javax.swing.JPanel {

    /**
     * Creates new form Itenerary
     */
    public Itenerary() {
        initComponents();
    }
    
    public Itenerary(ArrayList<Activity> Today) {
        initComponents();
    
        List<String> event_details = new ArrayList<String>();
        
        for (int i = 0; i < Today.size(); i++)
        {
            Activity temp = Today.get(i);
            String tstring = temp.getStartTime().toString() + temp.getStopTime().toString();
            
            event_details.add(temp.getExtraInfo());
            event_details.add(tstring);
            
        }
        
        
        
        Object[][] table_list = new Object[Today.size()][Today.size()];
        for (int r = 0; r < table_list.length; r++) 
        {
            for (int c = 0; c < table_list[r].length; c++)
            {
                table_list[r][c] = event_details.get(c);
            }
            
        
        
            
        }
        
        
        
    }
    
    
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Time", "Event"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}