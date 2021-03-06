/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPConsultarFatura.java
 *
 * Created on May 7, 2012, 7:48:51 PM
 */
package presentation.Fatura;

/**
 *
 * @author Nelson
 */
public class JPConsultarFatura extends javax.swing.JPanel {

    /** Creates new form JPConsultarFatura */
    public JPConsultarFatura() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConsultarFaturas = new javax.swing.JLabel();
        jLabelFatura = new javax.swing.JLabel();
        jComboBoxFatura = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalhes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResumo = new javax.swing.JTable();
        jLabelResumo = new javax.swing.JLabel();
        jLabelDetalhes = new javax.swing.JLabel();
        jToggleButtonConfirmar = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabelConsultarFaturas.setFont(new java.awt.Font("Cambria", 1, 30)); // NOI18N
        jLabelConsultarFaturas.setText("Consultar faturas");

        jLabelFatura.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFatura.setText("Fatura:");

        jComboBoxFatura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFaturaActionPerformed(evt);
            }
        });

        jTableDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Hora", "Duração", "Valor", "Local", "Número", "Responsáveis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetalhes);
        jTableDetalhes.getColumnModel().getColumn(0).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(1).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(2).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(3).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(4).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(5).setResizable(false);
        jTableDetalhes.getColumnModel().getColumn(6).setResizable(false);

        jTableResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor(R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableResumo);
        jTableResumo.getColumnModel().getColumn(0).setResizable(false);
        jTableResumo.getColumnModel().getColumn(1).setResizable(false);

        jLabelResumo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelResumo.setText("Resumo");

        jLabelDetalhes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelDetalhes.setText("Detalhes");

        jToggleButtonConfirmar.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jLabelResumo)
                    .addComponent(jLabelDetalhes)
                    .addComponent(jLabelConsultarFaturas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFatura)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jToggleButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConsultarFaturas)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFatura)
                    .addComponent(jComboBoxFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButtonConfirmar))
                .addGap(30, 30, 30)
                .addComponent(jLabelResumo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDetalhes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jComboBoxFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFaturaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBoxFaturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxFatura;
    private javax.swing.JLabel jLabelConsultarFaturas;
    private javax.swing.JLabel jLabelDetalhes;
    private javax.swing.JLabel jLabelFatura;
    private javax.swing.JLabel jLabelResumo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableDetalhes;
    private javax.swing.JTable jTableResumo;
    private javax.swing.JToggleButton jToggleButtonConfirmar;
    // End of variables declaration//GEN-END:variables
}
