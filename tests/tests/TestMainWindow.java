//package tests;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.interfaces.MainWindow;
//
//public class TestMainWindow {
//
//	private MainWindow mainWindow;
//
//    @Before
//    public void setUp() {
//        mainWindow = new MainWindow();
//    }
//
//    @Test
//    public void testChangeLan() {
//        mainWindow.langComboBox.setSelectedItem("Español");
//
//        mainWindow.changeLan();
//
//        assertEquals("Cartelera", mainWindow.bBill.getText());
//        assertEquals("Reseñas", mainWindow.bRe.getText());
//        assertEquals("Reservas", mainWindow.bReser.getText());
//    }
//
//
//}
