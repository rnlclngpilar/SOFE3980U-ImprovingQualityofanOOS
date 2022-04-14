package pack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ChitChatAppTest {
    JTextField name1;
    JTextField port1;
    JTextField name2;
    JTextField port2;
    JRadioButton host;
    JRadioButton client;
    JTextArea msg1;
    JTextArea msg2;
    JLabel cstatus1;
    JLabel cstatus2;
    JLabel chatWithlabel1;
    JLabel chatWithlabel2;
    JTextArea reply1;
    JTextArea reply2;
    JButton connect1;
    JButton connect2;
    JButton disconnect2;
    JButton send1;
    JButton send2;
    pack.ChitChatApp2 chat1;
    ChitChatApp2 chat2;
    @BeforeEach
    public void beforeAll() {
        chat1 = new pack.ChitChatApp2();
        chat2 = new ChitChatApp2();

        name1 = (JTextField) TestUtils.getChildNamed(chat1,"nameField");
        assertNotNull(name1);
        port1 = (JTextField) TestUtils.getChildNamed(chat1,"portField");
        assertNotNull(port1);
        host = (JRadioButton) TestUtils.getChildNamed(chat1,"hostButton");
        assertNotNull(host);

        msg1= (JTextArea)   TestUtils.getChildNamed(chat1,"sender");
        assertNotNull(msg1);

        cstatus1= (JLabel) TestUtils.getChildNamed(chat1,"cStatuslabel");
        assertNotNull(cstatus1);
        chatWithlabel1= (JLabel) TestUtils.getChildNamed(chat1,"chatWithlabel");
        assertNotNull(chatWithlabel1);
        reply1 = (JTextArea)   TestUtils.getChildNamed(chat1,"replyArea");
        assertNotNull(reply1);
        connect1=(JButton) TestUtils.getChildNamed(chat1,"connectButton");
        assertNotNull(connect1);
        send1=(JButton) TestUtils.getChildNamed(chat1,"sendButton");
        assertNotNull(send1);

        name2 = (JTextField) TestUtils.getChildNamed(chat2,"nameField"); //getting gui components and  making sure its not null
        assertNotNull(name2);
        port2 = (JTextField) TestUtils.getChildNamed(chat2,"portField"); //getting gui components and  making sure its not null
        assertNotNull(port2);
        client = (JRadioButton) TestUtils.getChildNamed(chat2,"clientButton");
        assertNotNull(client);

        msg2= (JTextArea)   TestUtils.getChildNamed(chat2,"sender");
        assertNotNull(msg2);

        cstatus2= (JLabel) TestUtils.getChildNamed(chat2,"cStatuslabel");
        assertNotNull(cstatus2);
        chatWithlabel2= (JLabel) TestUtils.getChildNamed(chat2,"chatWithlabel");
        assertNotNull(chatWithlabel2);
        reply2 = (JTextArea)   TestUtils.getChildNamed(chat2,"replyArea");
        assertNotNull(reply2);
        connect2=(JButton) TestUtils.getChildNamed(chat2,"connectButton");
        assertNotNull(connect2);
        disconnect2=(JButton) TestUtils.getChildNamed(chat2,"disconnectButton");
        assertNotNull(disconnect2);
        send2=(JButton) TestUtils.getChildNamed(chat2,"sendButton");
        assertNotNull(send2);
    }
    @AfterEach
    public void cleanUpEach(){
       chat1.dispose();
       chat2.dispose();
    }

    @Test
    void chatTest() throws InterruptedException { //Test to see if message send properly
        host.setSelected(true);
        client.setSelected(true); // clicking user and host button

        name1.setText("User1");
        name1.postActionEvent(); //setting user 1 information then hosting
        port1.setText("556");
        port1.postActionEvent();
        connect1.doClick();

        name2.setText("User2");
        name2.postActionEvent(); //Setting user 2 information then connecting to User 1
        port2.setText("556");
        port2.postActionEvent();
        connect2.doClick();

        TimeUnit.SECONDS.sleep(1); //wait 1 second

        msg1.setText("Hello"); //Send a message from host
        send1.doClick();

        TimeUnit.SECONDS.sleep(1); //wait for user to receive message

        assertTrue(reply2.getText().contains("User1: Hello")); //assert that user2 receives the message.

        msg2.setText("Hi"); //trying send a message from client
        send2.doClick();


        TimeUnit.SECONDS.sleep(1); //wait for user to receive message

        assertTrue(reply1.getText().contains("User2: Hi")); //assert that user1 receives the message.
    }

    @Test
    void connectionTest() throws InterruptedException { //Test to see if connection can be mind
        assertEquals("Connection Status: Disconnected",cstatus1.getText()); // first check to see host/cient are not connected to one another at start
        assertEquals("Connection Status: Disconnected",cstatus2.getText());
        host.setSelected(true);
        client.setSelected(true); // clicking user and host button

        name1.setText("User1");
        name1.postActionEvent(); //setting user 1 information then hosting
        port1.setText("555");
        port1.postActionEvent();
        connect1.doClick();

        name2.setText("User2");
        name2.postActionEvent(); //Setting user 2 information then connecting to User 1
        port2.setText("555");
        port2.postActionEvent();
        connect2.doClick();

        TimeUnit.SECONDS.sleep(1);

        assertEquals("Connection Status: Connected",cstatus1.getText()); //See if host/client is connected
        assertEquals("Connection Status: Connected",cstatus2.getText());
    }
    @Test
    void nameTest() throws InterruptedException { //Test to see if names are sent properly
        assertEquals("Not Chatting with anyone",chatWithlabel1.getText()); //make sure not chatting with anyone at start
        assertEquals("Not Chatting with anyone",chatWithlabel2.getText());
        host.setSelected(true);
        client.setSelected(true); // clicking user and host button

        name1.setText("User1");
        name1.postActionEvent(); //setting user 1 information then hosting
        port1.setText("557");
        port1.postActionEvent();
        connect1.doClick();

        name2.setText("User2");
        name2.postActionEvent(); //Setting user 2 information then connecting to User 1
        port2.setText("557");
        port2.postActionEvent();
        connect2.doClick();

        TimeUnit.SECONDS.sleep(1);

        assertEquals("Connected to: User2",chatWithlabel1.getText());
        assertEquals("Connected to: User1",chatWithlabel2.getText());
    }

    @Test
    void disconnectTest() throws InterruptedException { //Test to see if client disconnects properly.
        host.setSelected(true);
        client.setSelected(true); // clicking user and host button

        name1.setText("User1");
        name1.postActionEvent(); //setting user 1 information then hosting
        port1.setText("558");
        port1.postActionEvent();
        connect1.doClick();

        name2.setText("User2");
        name2.postActionEvent(); //Setting user 2 information then connecting to User 1
        port2.setText("558");
        port2.postActionEvent();
        connect2.doClick();

        TimeUnit.SECONDS.sleep(1);
        disconnect2.doClick();
        TimeUnit.SECONDS.sleep(1);

        assertEquals("Connection Status: Disconnected",cstatus1.getText()); //make sure host/client disconnect
        assertEquals("Connection Status: Disconnected",cstatus2.getText());
    }

}