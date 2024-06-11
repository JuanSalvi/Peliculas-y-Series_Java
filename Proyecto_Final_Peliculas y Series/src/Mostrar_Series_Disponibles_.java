import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Mostrar_Series_Disponibles_ extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Series_Disponibles_ frame = new Mostrar_Series_Disponibles_();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mostrar_Series_Disponibles_() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Series Diponibles\r\n");
		label.setForeground(new Color(106, 90, 205));
		label.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		label.setBounds(137, 11, 172, 14);
		contentPane.add(label);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(32, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JButton button = new JButton("Regresar");
		button.setBounds(174, 227, 89, 23);
		contentPane.add(button);
	}
}
