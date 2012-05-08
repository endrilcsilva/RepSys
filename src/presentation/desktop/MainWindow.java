/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on May 6, 2012, 3:30:40 PM
 */
package presentation.desktop;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import presentation.JPLogin;
import presentation.lib.ReturnEvent;


/**
 *
 * @author danilogr
 */
public class MainWindow extends javax.swing.JFrame {

    /*
     * Parte do sistema que trabalha o movimento das janelas internas
     */
    private List<ReturnEvent> eventosDeRetorno; //pilha de eventos de retorno
    private List<String> eventosDeRetornoNome;  //pilha com os identificadores dos eventos
    
    /*
     * Parte que cuida da autenticação
     */
    private boolean USUARIO_AUTENTICADO = false;
    // #TODO: DECLARAR VARIAVEL PARA GUARDAR OBJETO DO USUARIO AUTENTICADO.
    
    private CardLayout content;
    
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        
        //Cria a lista de eventos de retorno
        eventosDeRetorno = new ArrayList<ReturnEvent>();
        eventosDeRetornoNome = new ArrayList<String>();
        
        //salva os CardLayouts
        content = (CardLayout) jPanelContent.getLayout();
        
        //Instanciar a tela de Login
        //JPLogin login = new JPLogin();
        //jPanelLoginArea.add(login, LOGIN);
        //loginArea.show(jPanelLoginArea, LOGIN);
        
        //INSTANCIAR AQUI A JANELA PRINCIPAL
        JPLogin jlogin = new JPLogin();   
        showCard(jlogin, jlogin);
    
            
    }
    
    /**  **/
    
    public void showCard(ReturnEvent callback, javax.swing.JPanel card)
    {
       
        String cardName = Integer.toString(eventosDeRetorno.size());
        eventosDeRetornoNome.add(cardName);
        eventosDeRetorno.add(callback);
        
        jPanelContent.add(card,cardName);
        content.show(jPanelContent,cardName);
    }
 
    /*
      Funcao que fecha um objeto
     */
    public void closeCurrentCard(Object returnedValue)
    {
        if(!eventosDeRetorno.isEmpty())
        {
            int index = eventosDeRetornoNome.size();
            ReturnEvent re = eventosDeRetorno.remove(index-1);
            eventosDeRetornoNome.remove(index-1);
            
            //apenas executa a funcao de retorno quando o valor retornado for diferente de null
            //e quando nao for a primeira janela criada (mesmo que ela indique um valor de retorno)
            if(eventosDeRetorno.size() >= 1 && returnedValue != null)
            {
                //chama a funcao de retorno
                re.onReturnFromOtherWindow(returnedValue);
            }
            
            jPanelContent.remove(this);
            content.show(jPanelContent, eventosDeRetornoNome.get(index-2));
        }   

    }
    
    
    public void closeCurrentCard()
    {
        closeCurrentCard(null);
    }
    
    
    /*
       Funcao que permite pegar o objeto corrente desta classes
     */
    static private MainWindow mainwindow = null;
    
    public static MainWindow getInstance()
    {
        if(mainwindow == null)
        {
            mainwindow = new MainWindow();
        }
        return mainwindow;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jPanelContainerBottom = new javax.swing.JPanel();
        jScrollPanelContent = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanelTop.setName("jPanelTop"); // NOI18N

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );

        jPanelContainerBottom.setName("jPanelContainerBottom"); // NOI18N

        jScrollPanelContent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPanelContent.setName("jScrollPanelContent"); // NOI18N

        jPanelContent.setName("jPanelContent"); // NOI18N
        jPanelContent.setLayout(new java.awt.CardLayout());
        jScrollPanelContent.setViewportView(jPanelContent);

        jPanelMenu.setName("jPanelMenu"); // NOI18N

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelContainerBottomLayout = new javax.swing.GroupLayout(jPanelContainerBottom);
        jPanelContainerBottom.setLayout(jPanelContainerBottomLayout);
        jPanelContainerBottomLayout.setHorizontalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerBottomLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
        );
        jPanelContainerBottomLayout.setVerticalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContainerBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContainerBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                getInstance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContainerBottom;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPanelContent;
    // End of variables declaration//GEN-END:variables

    

}
