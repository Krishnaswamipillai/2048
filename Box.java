import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class Box extends JLabel{
	private int value;
	public Box(){
		int rand = (int)(Math.random()*10);
		if(rand == 0){
			value = 4;
		}
		else if(rand <= 3){
			value = 2;
		}
		else{
			value = 0;
		}
		this.setText("" + value);
		this.setHorizontalAlignment(CENTER);
		this.setFont(new Font("Ariel", Font.BOLD, 25));
		color();
	}
	public void sVal(int v){
		value = v;
		this.setText("" + value);
		color();
		if(value == 0){
			this.setVisible(false);
		}
		else{
			this.setVisible(true);
		}
	}
	public int gVal(){
		return value;
	}
	public void color(){
		if(value == 2){
			this.setBackground(Color.LIGHT_GRAY);
		}
		else if(value == 4){
			this.setBackground(Color.LIGHT_GRAY);
		}
		else if(value == 8){
			this.setBackground(Color.LIGHT_GRAY);
		}
		else if(value == 16){
			this.setBackground(Color.ORANGE);
		}
		else if(value == 32){
			this.setBackground(Color.magenta);
		}
		else if(value == 64){
			this.setBackground(Color.GREEN);
		}
		else if(value == 128){
			this.setBackground(Color.white);
		}
		else if(value == 256){
			this.setBackground(Color.YELLOW);
		}
		else if(value == 512){
			this.setBackground(Color.CYAN);
		}
		else if(value == 1024){
			this.setBackground(Color.PINK);
		}
		else if(value == 2048){
			this.setBackground(Color.RED);
		}
		this.setOpaque(true);
	}
}
