package meuBot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class youtube extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					youtube frame = new youtube();
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
	public youtube() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 751, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Youtube finder");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(278, 38, 238, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 37));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 119, 751, 253);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(193, 55, 423, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WebDriver driver = null;
		        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://www.youtube.com");
		        WebElement campPesquisa = driver.findElement(By.name("search_query"));
		        campPesquisa.sendKeys(textField.getText());
		        WebElement btnBuscar = driver.findElement(By.id("search-icon-legacy"));
		        btnBuscar.click();
		        WebElement video = driver.findElement(By.xpath("//a[@id=\"video-title\"]"));
		        video.click();
			}
		});
		btnNewButton.setBounds(316, 150, 178, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Candy Beans", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(296, 24, 92, 14);
		panel_1.add(lblNewLabel_1);
	}
}
