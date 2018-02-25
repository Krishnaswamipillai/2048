import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class Board2048 extends JFrame implements KeyListener{
	ArrayList<Point> zeroes = new ArrayList<Point>();
	int row = 8;
	int col = 8;
	Box[][] boxes = new Box[row][col];
	public Board2048(){
		this.setVisible(true);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setLayout(new GridLayout(row,col,5,5));
		addKeyListener(this);
		for(int x = 0; x < row; x++){
			for(int y = 0; y < col; y++){
				Box box = new Box();
				this.add(box);
				box.setVisible(true);
				box.setOpaque(true);
				box.sVal(0);
				boxes[x][y] = box;
				if(boxes[x][y].gVal() == 0){
					zeroes.add(new Point(x,y));
				}
			}
		}
		for(int n = 0; n < 2; n++){
			int rand = (int)(Math.random()*zeroes.size());
			int random = (int)(Math.random()*10);
			if(random < 2){
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(4);
			}
			else{
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(2);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent key) {
		try{
		if(key.getKeyCode() == KeyEvent.VK_DOWN){
			this.getContentPane().removeAll();
			zeroes.removeAll(zeroes);
			for(int x = row - 1; x > 0; x--){
				for(int y = 0; y < col; y++){
					if(boxes[x][y].gVal() == 0){
							for(int r = x; r > 0; r--){
								if(boxes[r-1][y].gVal() != 0){
									boxes[x][y].sVal(boxes[r-1][y].gVal());
									boxes[r-1][y].sVal(0);
									break;
								}
							}
					}
				}
			}
			for(int x = row - 1; x > 0; x--){
				for(int y = 0; y < col; y++){
					if(boxes[x][y].gVal() == boxes[x-1][y].gVal()){
						boxes[x][y].sVal(boxes[x][y].gVal()*2);
						boxes[x-1][y].sVal(0);
					}
				}
			}
			for(int n = row - 1; n > 0; n--){
				for(int y = 0; y < col; y++){
					if(boxes[n][y].gVal() == 0){
						for(int r = n; r > 0; r--){
							if(boxes[r-1][y].gVal() != 0){
									boxes[n][y].sVal(boxes[r-1][y].gVal());
									boxes[r-1][y].sVal(0);
									break;
							}
						}
					}
				}
			}
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					if(boxes[r][c].gVal() == 0){
						zeroes.add(new Point(r,c));
						boxes[r][c].setVisible(false);
					}
				}
			}
			int rand = (int)(Math.random()*zeroes.size());
			int random = (int)(Math.random()*10);
			if(random < 2){
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(4);
			}
			else{
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(2);
			}
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setVisible(true);
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setOpaque(true);
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					this.getContentPane().add(boxes[r][c]);
					boxes[r][c].setVisible(true);
					boxes[r][c].setOpaque(true);
					if(boxes[r][c].gVal() == 0){
						boxes[r][c].setVisible(false);
					}
				}
			}
			this.repaint();
		}
		if(key.getKeyCode() == KeyEvent.VK_UP){
			this.getContentPane().removeAll();
			zeroes.removeAll(zeroes);
			for(int x = 0; x < row - 1; x++){
				for(int y = 0; y < col; y++){
					if(boxes[x][y].gVal() == 0){
							for(int r = x; r < row - 1; r++){
								if(boxes[r+1][y].gVal() != 0){
									boxes[x][y].sVal(boxes[r+1][y].gVal());
									boxes[r+1][y].sVal(0);
									break;
								}
							}
					}
				}
			}
			for(int x = 0; x < row - 1; x++){
				for(int y = 0; y < col; y++){
					if(boxes[x][y].gVal() == boxes[x+1][y].gVal()){
						boxes[x][y].sVal(boxes[x][y].gVal()*2);
						boxes[x+1][y].sVal(0);
					}
				}
			}
			for(int n = 0; n < row - 1; n++){
				for(int y = 0; y < col; y++){
					if(boxes[n][y].gVal() == 0){
						for(int r = n; r < row - 1; r++){
							if(boxes[r+1][y].gVal() != 0){
									boxes[n][y].sVal(boxes[r+1][y].gVal());
									boxes[r+1][y].sVal(0);
									break;
							}
						}
					}
				}
			}
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					if(boxes[r][c].gVal() == 0){
						zeroes.add(new Point(r,c));
						boxes[r][c].setVisible(false);
					}
				}
			}
			int rand = (int)(Math.random()*zeroes.size());
			int random = (int)(Math.random()*10);
			if(random < 2){
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(4);
			}
			else{
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(2);
			}
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setVisible(true);
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setOpaque(true);
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					this.getContentPane().add(boxes[r][c]);
					boxes[r][c].setVisible(true);
					boxes[r][c].setOpaque(true);
					if(boxes[r][c].gVal() == 0){
						boxes[r][c].setVisible(false);
					}
				}
			}
			this.repaint();
		}
		if(key.getKeyCode() == KeyEvent.VK_RIGHT){
			this.getContentPane().removeAll();
			zeroes.removeAll(zeroes);
			for(int y = col - 1; y > 0; y--){
				for(int x = 0; x < row; x++){
					if(boxes[x][y].gVal() == 0){
							for(int r = y; r > 0; r--){
								if(boxes[x][r-1].gVal() != 0){
									boxes[x][y].sVal(boxes[x][r-1].gVal());
									boxes[x][r-1].sVal(0);
									break;
								}
							}
					}
				}
			}
			for(int y = col - 1; y > 0; y--){
				for(int x = 0; x < row; x++){
					if(boxes[x][y].gVal() == boxes[x][y-1].gVal()){
						boxes[x][y].sVal(boxes[x][y].gVal()*2);
						boxes[x][y-1].sVal(0);
					}
				}
			}
			for(int y = col - 1; y > 0; y--){
				for(int n = 0; n < row; n++){
					if(boxes[n][y].gVal() == 0){
						for(int r = y; r > 0; r--){
							if(boxes[n][r-1].gVal() != 0){
									boxes[n][y].sVal(boxes[n][r-1].gVal());
									boxes[n][r-1].sVal(0);
									break;
							}
						}
					}
				}
			}
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					if(boxes[r][c].gVal() == 0){
						zeroes.add(new Point(r,c));
						boxes[r][c].setVisible(false);
					}
				}
			}
			int rand = (int)(Math.random()*zeroes.size());
			int random = (int)(Math.random()*10);
			if(random < 2){
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(4);
			}
			else{
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(2);
			}
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setVisible(true);
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setOpaque(true);
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					this.getContentPane().add(boxes[r][c]);
					boxes[r][c].setVisible(true);
					boxes[r][c].setOpaque(true);
					if(boxes[r][c].gVal() == 0){
						boxes[r][c].setVisible(false);
					}
				}
			}
			this.repaint();
		}
		if(key.getKeyCode() == KeyEvent.VK_LEFT){
			this.getContentPane().removeAll();
			zeroes.removeAll(zeroes);
			for(int y = 0; y < col - 1; y++){
				for(int x = 0; x < row; x++){
					if(boxes[x][y].gVal() == 0){
							for(int r = y; r < col - 1; r++){
								if(boxes[x][r+1].gVal() != 0){
									boxes[x][y].sVal(boxes[x][r+1].gVal());
									boxes[x][r+1].sVal(0);
									break;
								}
							}
					}
				}
			}
			for(int y = 0; y < col - 1; y++){
				for(int x = 0; x < row; x++){
					if(boxes[x][y].gVal() == boxes[x][y+1].gVal()){
						boxes[x][y].sVal(boxes[x][y].gVal()*2);
						boxes[x][y+1].sVal(0);
					}
				}
			}
			for(int y = 0; y < col - 1; y++){
				for(int n = 0; n < row; n++){
					if(boxes[n][y].gVal() == 0){
						for(int r = y; r < col - 1; r++){
							if(boxes[n][r+1].gVal() != 0){
									boxes[n][y].sVal(boxes[n][r+1].gVal());
									boxes[n][r+1].sVal(0);
									break;
							}
						}
					}
				}
			}
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					if(boxes[r][c].gVal() == 0){
						zeroes.add(new Point(r,c));
					}
				}
			}
			int rand = (int)(Math.random()*zeroes.size());
			int random = (int)(Math.random()*10);
			if(random < 2){
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(4);
			}
			else{
				boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].sVal(2);
			}
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setVisible(true);
			boxes[zeroes.get(rand).gR()][zeroes.get(rand).gC()].setOpaque(true);
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					this.getContentPane().add(boxes[r][c]);
					boxes[r][c].setVisible(true);
					boxes[r][c].setOpaque(true);
					if(boxes[r][c].gVal() == 0){
						boxes[r][c].setVisible(false);
					}
				}
			}
			this.repaint();
		}
		boolean win = false;
		for(int r = 0; r < row; r++){
			for(int c = 0; c < col; c++){
				if(boxes[r][c].gVal() == 2048){
					win = true;
				}
			}
		}
		if(win){
			this.getContentPane().removeAll();
			repaint();
			for(int r = 0; r < row; r++){
				for(int c = 0; c < col; c++){
					JLabel winner = new JLabel("All Glory Is For Rohit! Bask In His Glory!");
					winner.setVisible(true);
					this.add(winner);
				}
			}
			repaint();
		}
		repaint();
		}
		catch(Exception e){
			this.removeAll();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			System.out.println("Uh Oh! You Lost! The Game Did Not Like You So It Closed Out!");
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	public static void main(String[] args){
			Board2048 game = new Board2048();
	}
}
