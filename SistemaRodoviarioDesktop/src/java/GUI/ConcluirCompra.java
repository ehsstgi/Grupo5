/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.naming.InitialContext;
import javax.swing.JOptionPane;
import sistemarodoviario.LinhaSessionBeanRemote;
import sistemarodoviario.PedidoSessionBeanRemote;
import sistemarodoviario.jpa.DataHora;
import sistemarodoviario.jpa.Linha;
import sistemarodoviario.jpa.Pedido;

/**
 *
 * @author Bruno
 */
public class ConcluirCompra extends javax.swing.JFrame {
    
    String nomeCliente;
    String cpf;
    String linha;
    String parada;
    int precoUnid;
    int qtdPassagem;
    String assentosList;
    int precoFin;
    String dataViagem;
    String horario;
    Linha l;
    
    

    /**
     * Creates new form ConcluirCompra
     */
    public ConcluirCompra() {
        initComponents();
    }

    public ConcluirCompra(String nomeCliente, String cpf, String linha, String parada, int precoUnid, int qtdPassagem, String assentos, String dataViagem, String horario, Linha l) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.linha = linha;
        this.parada = parada;
        this.precoUnid = precoUnid;
        this.qtdPassagem = qtdPassagem;
        this.assentosList = assentos;
        this.precoFin = precoUnid * qtdPassagem;
        this.dataViagem = dataViagem;
        this.horario = horario;
        this.l = l;
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JLabel();
        cpfCliente = new javax.swing.JLabel();
        tituloViagem = new javax.swing.JLabel();
        linhaViagem = new javax.swing.JLabel();
        paradaViagem = new javax.swing.JLabel();
        precoUnidade = new javax.swing.JLabel();
        qtdPassagens = new javax.swing.JLabel();
        precoFinal = new javax.swing.JLabel();
        assentos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nome.setText(nomeCliente);

        cpfCliente.setText(cpf);

        tituloViagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloViagem.setText("Dados da Viagem");

        linhaViagem.setText("Linha: "+linha);

        paradaViagem.setText("Parada: "+parada);

        precoUnidade.setText("Preço da Passagem: R$"+String.valueOf(precoUnid)+",00");

        qtdPassagens.setText("Quantidade de Passagens: "+String.valueOf(qtdPassagem));

        precoFinal.setText("Preço Final: R$"+String.valueOf(precoFin)+",00");

        assentos.setText("Assentos escolhidos: "+assentosList);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Data da Viagem: "+dataViagem);

        jLabel2.setText("Horário: "+horario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(105, 105, 105)
                                    .addComponent(cpfCliente))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(linhaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(paradaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(tituloViagem)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precoFinal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(precoUnidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qtdPassagens, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(cpfCliente))
                .addGap(65, 65, 65)
                .addComponent(tituloViagem)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linhaViagem)
                    .addComponent(paradaViagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(assentos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(precoUnidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtdPassagens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoFinal)))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            InitialContext context = new InitialContext();
            PedidoSessionBeanRemote beanPedido = (PedidoSessionBeanRemote) context.lookup("ejb/Pedido");
            LinhaSessionBeanRemote beanLinha = (LinhaSessionBeanRemote) context.lookup("ejb/Linha");
            DataHora dh = beanLinha.retornaDataHora(l, dataViagem, horario);
            Pedido pedido = new Pedido(l, dh);
            beanPedido.salvar(pedido);
            JOptionPane.showMessageDialog(null,"Pedido confirmado!");
            new InicioGUI().setVisible(true);
            this.dispose();
        } catch (Exception e) {}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConcluirCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConcluirCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConcluirCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConcluirCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConcluirCompra().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assentos;
    private javax.swing.JLabel cpfCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel linhaViagem;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel paradaViagem;
    private javax.swing.JLabel precoFinal;
    private javax.swing.JLabel precoUnidade;
    private javax.swing.JLabel qtdPassagens;
    private javax.swing.JLabel tituloViagem;
    // End of variables declaration//GEN-END:variables
}
