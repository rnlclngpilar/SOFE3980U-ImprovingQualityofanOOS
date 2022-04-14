package pack;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.net.*;
import java.util.Objects;


public class ChitChatApp2 extends javax.swing.JFrame
{
    final String[] status = {"Connected","Disconnected"};
    String cstatus = status[1];
    String person2 = "";
    String username = "";
    int portnum = 0;
    String  Ipaddress = "";
    ServerSocket ssc = null;
    Socket sc = null;
       DataOutputStream out;
       DataInputStream in;
    
    /**
     * Creates new form ChapAppJavaG
     */
    public ChitChatApp2() {
        initComponents();
        hostButton.setName("hostButton");
        clientButton.setName("clientButton");
        ipField.setName("ipField");
        portField.setName("portField");
        nameField.setName("nameField");
        connectButton.setName("connectButton");
        disconnectButton.setName("disconnectButton");
        replyArea.setName("replyArea");
        sender.setName("sender");
        sendButton.setName("sendButton");
        cStatuslabel.setName("cStatuslabel");
        chatWithlabel.setName("chatWithlabel");
        seticon();
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        hostButton = new javax.swing.JRadioButton();
        clientButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        chatWithlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        replyArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cStatuslabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sender = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChitChat V2.1 by Navdeep Mishra");
        setMinimumSize(new java.awt.Dimension(632, 417));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(632, 417));
        jPanel1.setMinimumSize(new java.awt.Dimension(632, 417));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(300, 422));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 422));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 422));

        hostButton.setText("Host");
        hostButton.addActionListener(this::hostButtonActionPerformed);

        clientButton.setText("Client");
        clientButton.addActionListener(this::clientButtonActionPerformed);

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 35, 35));
        jLabel3.setText("IP Address");

        ipField.setText("localhost");
        ipField.addActionListener(this::ipFieldActionPerformed);

        jLabel4.setForeground(new java.awt.Color(36, 35, 35));
        jLabel4.setText("Port Number");

        portField.addActionListener(this::portFieldActionPerformed);

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 35, 35));
        jLabel5.setText("Your Name");

        connectButton.setBackground(new java.awt.Color(255, 255, 255));
        connectButton.setText("Connect");
        connectButton.addActionListener(this::connectButtonActionPerformed);

        disconnectButton.setBackground(new java.awt.Color(255, 255, 255));
        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(this::disconnectButtonActionPerformed);

        chatWithlabel.setForeground(new java.awt.Color(36, 35, 35));
        chatWithlabel.setText("Not Chatting with anyone");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatWithlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ipField)
                    .addComponent(portField)
                    .addComponent(nameField)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(hostButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostButton)
                    .addComponent(clientButton))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(chatWithlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 240, 420);

        replyArea.setColumns(20);
        replyArea.setRows(5);
        jScrollPane1.setViewportView(replyArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 150, 370, 100);

        sendButton.setBackground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Send");
        sendButton.addActionListener(this::sendButtonActionPerformed);
        jPanel1.add(sendButton);
        sendButton.setBounds(570, 310, 59, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        jLabel1.setText("Reply Received");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(250, 120, 200, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        jLabel2.setText("Your Message:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 260, 109, 23);

        cStatuslabel.setText("Connection Status: Disconnected");
        jPanel1.add(cStatuslabel);
        cStatuslabel.setBounds(250, 390, 390, 30);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Times New Roman", Font.ITALIC, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("        Chit Chat - Lets Chat");
        jLabel8.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(240, 0, 390, 80);

        sender.setColumns(20);
        sender.setRows(5);
        jScrollPane2.setViewportView(sender);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(262, 310, 290, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void portFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portFieldActionPerformed

    }//GEN-LAST:event_portFieldActionPerformed

    private void ipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipFieldActionPerformed

    }//GEN-LAST:event_ipFieldActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed

        hostButton.setSelected(false);
        ipField.setEditable(true);
    }//GEN-LAST:event_clientButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

        if (hostButton.isSelected())                   //Connect funcitonality for the host.
        {
           new Thread(() -> {
               try
                {
                    if(nameField.getText().isEmpty())
                    {
//

                        throw new Exception("Name Field can't be empty");
                    }
                    if(portField.getText().isEmpty())
                    {
                        throw new Exception("The Port Number Can't be Empty");
                    }
                    if(ipField.getText().isEmpty())
                    {
                        throw new Exception("IpAddress field can't be Emptj");

                    }
                    username = nameField.getText();
                    portnum = Integer.parseInt(portField.getText());
//
                    Ipaddress = ipField.getText();
                    ssc = new ServerSocket(portnum);

                    sc = ssc.accept();
                    cstatus = status[0];

                    out = new DataOutputStream(sc.getOutputStream());
                    out.writeUTF(username);
                    in = new DataInputStream(sc.getInputStream());
                    person2 = in.readUTF();
                    statusVerifier(true);

//
                    new Thread(() -> {  try
                        {
                        while(true)

                            {
                                String msgg;
                                 msgg=in.readUTF();

                                 replyArea.setEditable(true);

                                 replyArea.append(person2+": "+msgg+"\n");
                                 replyArea.setEditable(false);
                            }
                        }
                        catch(SocketException ee)
                        {
                            JFrame jf = new JFrame("Message");
                        }
                        catch(EOFException ee)
                        {
                            JFrame jf = new JFrame("Message");
                            cstatus = status[1];
                            statusVerifier(false);
                        }
                        catch(Exception ee)
                            {
                                     JFrame jf = new JFrame("Message");
                                     JOptionPane.showMessageDialog(jf,ee);
//
                            }
                    }).start();


                }
               catch(SocketException se)
               {
                   statusVerifier(false);
                   JFrame jf = new JFrame("Error Occurred");
                   JOptionPane.showMessageDialog(jf,se);
//                       se.printStackTrace();

               }

               catch(Exception e)
               {
                   JFrame jf = new JFrame("Error Occurred");
                   JOptionPane.showMessageDialog(jf,e);
//                       e.printStackTrace();


               }

           }).start();
        }
        if (clientButton.isSelected())          //connect functionality for the client
        {
            new Thread(() -> {
                try
                 {
                     if(nameField.getText().isEmpty())
                     {

                         throw new Exception("Name Field can't be empty");
                     }
                     if(portField.getText().isEmpty())
                     {
                         throw new Exception("The Port Number Can't be Empty");
                     }
                     if(ipField.getText().isEmpty())
                     {
                         throw new Exception("IpAddress field can't be Emptj");

                     }
                     Ipaddress = ipField.getText();
                     portnum = Integer.parseInt(portField.getText());
                     sc = new Socket(Ipaddress,portnum);

                     cstatus = status[0];
                     username = nameField.getText();
//

                     in = new DataInputStream(sc.getInputStream());
                     person2 = in.readUTF();
                     out = new DataOutputStream(sc.getOutputStream());
                     out.writeUTF(username);
                     statusVerifier(true);
//

//
                     new Thread(() -> {  try
                         {
                         while(true)

                             {
                                 String msgg;
                                  msgg=in.readUTF();
                                  replyArea.setEditable(true);
//
                                  replyArea.append(person2+": "+msgg+"\n");
                                  replyArea.setEditable(false);
                             }
                         }
                         catch(EOFException ee)
                         {
                             JFrame jf = new JFrame("Message");
                             JOptionPane.showMessageDialog(jf,person2+" Has Ended the Chat");
//                                    ee.printStackTrace();
                             cstatus=status[1];
                             statusVerifier(false);
                         }
                          catch(SocketException se)
                             {
                                 statusVerifier(false);
                                 JFrame jf = new JFrame("Error Occurred");
                                 JOptionPane.showMessageDialog(jf,"You have Ended the Chat");
//                                        se.printStackTrace();

                             }
                         catch(Exception ee)
                             {
                                      JFrame jf = new JFrame("Message");
                                      JOptionPane.showMessageDialog(jf,ee);
//                                             ee.printStackTrace();
                             }
                     }).start();

                 }

                catch(SocketException se)
                {
                    statusVerifier(false);


                    JFrame jf = new JFrame("Error Occurred");
                    JOptionPane.showMessageDialog(jf,se);
//                       se.printStackTrace();

                }

                catch(Exception ee)
                 {
                     JFrame jf  = new JFrame("Message");
                     JOptionPane.showMessageDialog(jf,ee);
//                        ee.printStackTrace();

                 }

            }).start();
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed


        //sends the message
        new Thread(() -> {
//

            try
            {
                if(Objects.equals(cstatus, status[0]))
                {

                    out = new DataOutputStream(sc.getOutputStream());
                    String msg = sender.getText();
                    if(msg.isEmpty())
                    {
//
                    }
                    else
                    {
                        sender.setText("");
                        replyArea.append(username+": "+msg+"\n");
                        out.writeUTF(msg);
                    }

                }
            }


             catch(EOFException ee)
            {
                JFrame jf = new JFrame("Message");
                JOptionPane.showMessageDialog(jf,"Eof errrorr......................");
//                        ee.printStackTrace();
            }
            catch(Exception ee)
            {
                JFrame jf  = new JFrame("Message");
                JOptionPane.showMessageDialog(jf,ee);
                ee.printStackTrace();

            }
        }).start();
            
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void hostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostButtonActionPerformed
        clientButton.setSelected(false);
        ipField.setEditable(false);
    }//GEN-LAST:event_hostButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
      
        if(hostButton.isSelected())                      //Disconnect Function if host option selected
        {
            new Thread(() -> {
                try
                {

                    ssc.close();
                    sc.close();

                    cstatus = status[1];
                    statusVerifier(false);

                }
                catch(EOFException ee)
                {
                    JFrame jf = new JFrame("Message");
                    JOptionPane.showMessageDialog(jf,"Eof errrorr in disconnect button");

                }
                catch(Exception ee)
                {
                    JFrame jf = new JFrame("Message");
                    JOptionPane.showMessageDialog(jf,"server Disconnected button");
//                       ee.printStackTrace();
                }

            }).start();
        }
      
        if(clientButton.isSelected())                     //Disconnect Function if client option selected
        {
            new Thread(() -> {
                try
                {

                    sc.close();
                    cstatus = status[1];

                    statusVerifier(false);


                }
                catch(EOFException ee)
                {
                    JFrame jf = new JFrame("Message");
                    JOptionPane.showMessageDialog(jf,"Eof errrorr in disconnect button");
//                        ee.printStackTrace();
                }
                catch(Exception ee)
                {
                    JFrame jf = new JFrame("Message");
                    JOptionPane.showMessageDialog(jf,"client Disconnected button");
//                        ee.printStackTrace();

                }

            }).start();
        }
    }//GEN-LAST:event_disconnectButtonActionPerformed
void statusVerifier(boolean status1)                        //One of the most important funciton which verifies the status that the application 
{                                                           //connected or disconnected and perform the some gui operations.
    if(!status1 && Objects.equals(cstatus, status[1]))
    {
       try
       {
           if(hostButton.isSelected())
           {
            disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
            hostButton.setEnabled(true);
            clientButton.setEnabled(true);
            ipField.setEditable(true);
            portField.setEditable(true);
            nameField.setEditable(true);
            chatWithlabel.setText(cstatus);
            cStatuslabel.setText("Connection Status: "+cstatus);
            chatWithlabel.setText(status[1]);
            sendButton.setEnabled(false);
            portField.setEditable(true);
            replyArea.setEditable(false);
            ssc.close();
            sc.close();
           }
           if(clientButton.isSelected())
           {
               disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
            hostButton.setEnabled(true);
            clientButton.setEnabled(true);
            ipField.setEditable(true);
            portField.setEditable(true);
            nameField.setEditable(true);
            chatWithlabel.setText(cstatus);
            cStatuslabel.setText("Connection Status: "+cstatus);
            chatWithlabel.setText(status[1]);
            sendButton.setEnabled(false);
            portField.setEditable(true);
            replyArea.setEditable(false);
            
            sc.close();
           }
        }
        catch (Exception ee)
        {
            JFrame jf = new JFrame("Error");
            JOptionPane.showMessageDialog(jf,ee);
            ee.printStackTrace();
        }
        
        
        
    }
    else if(status1 && Objects.equals(cstatus, status[0]))
            {
                sendButton.setEnabled(true);
                replyArea.setText("");
                sender.setText("");  
                disconnectButton.setEnabled(true);
                connectButton.setEnabled(false);
                hostButton.setEnabled(false);
                clientButton.setEnabled(false);
                ipField.setEditable(false);
                portField.setEditable(false);
                nameField.setEditable(false);
                chatWithlabel.setText("Connected to: "+person2);
                
                cStatuslabel.setText("Connection Status: "+cstatus);
                portField.setEditable(false);
            }
    
}
void firsttimestatusverifier(boolean status2)           //This function disables some option when the gui is started. So that user can start the
{                                                       // application without encountering any bug.
    if(!status2 && Objects.equals(cstatus, status[1]))
    {
        try
        {
            disconnectButton.setEnabled(false);
            connectButton.setEnabled(true);
            hostButton.setEnabled(true);
            clientButton.setEnabled(true);
            ipField.setEditable(true);
            portField.setEditable(true);
            nameField.setEditable(true);
            chatWithlabel.setText(cstatus);
            cStatuslabel.setText("Connection Status: "+cstatus);
            chatWithlabel.setText(status[1]);
            sendButton.setEnabled(false);
            portField.setEditable(true);
            replyArea.setEditable(false);  
        
        }
        catch (Exception ee)
        {
            JFrame jf = new JFrame("Error");
            JOptionPane.showMessageDialog(jf,ee);
            ee.printStackTrace();
        }
    }
}
void seticon()
{
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png"))); //for setting icon
}

    
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChitChatApp2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
          ChitChatApp2 root = new ChitChatApp2();  //initializing the main gui
          root.setVisible(true);                   //making it visible
          root.firsttimestatusverifier(false);    // verify the status of the app for the first time.




        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cStatuslabel;
    private javax.swing.JLabel chatWithlabel;
    private javax.swing.JRadioButton clientButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JRadioButton hostButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField portField;
    private javax.swing.JTextArea replyArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea sender;
    // End of variables declaration//GEN-END:variables
}

/*
Created and Managed by Navdeep Mishra
*/