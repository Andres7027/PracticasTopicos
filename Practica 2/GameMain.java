import java.awt.*;
import java.awt.event.*;

public class GameMain extends Frame implements MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private Game obj_pintable;
	public GameMain() {
		initComponent();
	}
	
	public void initComponent() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		obj_pintable = new Game();
		obj_pintable.addMouseListener(this);
        obj_pintable.addMouseMotionListener(this);
        obj_pintable.addKeyListener(this);
        this.addKeyListener(this);
        this.add(obj_pintable);
        this.setSize(500,500);
        this.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{	
		GameMain test = new GameMain();
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseDragged(MouseEvent e) 
	{	
		if(!obj_pintable.isClicked())
		{
            obj_pintable.setX(e.getX());
            obj_pintable.setY(e.getY());
            obj_pintable.repaint();
        }
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) 
	{
		if(obj_pintable.isClicked())
		{
            obj_pintable.setW(e.getX());
            obj_pintable.setH(e.getY());
            obj_pintable.repaint();
        } else{
            obj_pintable.setX(e.getX());
            obj_pintable.setY(e.getY());
        }
        obj_pintable.setClicked();		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}