
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.ArithmeticException;

public class CalculadoraGUI extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;

    JButton op,btn_div,btn_igual,btn_suma,btn_mult,btn_elevar,btn_resta;
    JPanel p_superior,p_inferior;
    JButton[] arr_btn = new JButton[10]; JButton[] arr_col = new JButton[3];
    JTextField txt;
    int xd=1;


    public CalculadoraGUI(String nombre){

        super(nombre);
        setSize(500,400);
        panelSuperior();
        panelInferior();
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.setVisible(true);
        this.add(p_superior);
        this.add(p_inferior);
        this.pack();
        txt.setText("1234567890"); 
    }

    public void panelSuperior(){
        txt = new JTextField(40);
        p_superior = new JPanel();
        p_superior.setLayout(new FlowLayout());
        p_superior.add(txt);
       
    }
    public void panelInferior(){

        p_inferior = new JPanel();

        for(int i = 0; i < arr_btn.length; i++){
            arr_btn[i] = new JButton("" + i);
            arr_btn[i].addActionListener(this);
        }
        for(int i = 0; i < arr_col.length; i++){
            arr_col[i] = new JButton("C"+ (i + 1 ));
            arr_col[i].addActionListener(this);
        }
        op = new JButton("Op");
        btn_suma = new JButton("+");
        btn_resta = new JButton("-");
        btn_div = new JButton("/");
        btn_mult = new JButton("*");
        btn_igual = new JButton("=");
        btn_elevar = new JButton("^");

        op.addActionListener(this);
        btn_suma.addActionListener(this);
        btn_resta.addActionListener(this);
        btn_div.addActionListener(this);
        btn_mult.addActionListener(this);
        btn_igual.addActionListener(this);
        btn_elevar.addActionListener(this);

        p_inferior.setLayout(new GridLayout(5,4,8,8));

        
        p_inferior.add(arr_col[0]);
        p_inferior.add(arr_col[1]);
        p_inferior.add(arr_col[2]);
        p_inferior.add(op);
        p_inferior.add(arr_btn[1]);
        p_inferior.add(arr_btn[2]);
        p_inferior.add(arr_btn[3]);
        p_inferior.add(btn_suma);
        p_inferior.add(arr_btn[4]);
        p_inferior.add(arr_btn[5]);
        p_inferior.add(arr_btn[6]);
        p_inferior.add(btn_resta);
        p_inferior.add(arr_btn[7]);
        p_inferior.add(arr_btn[8]);
        p_inferior.add(arr_btn[9]);
        p_inferior.add(btn_div);
        p_inferior.add(btn_mult);
        p_inferior.add(arr_btn[0]);
        p_inferior.add(btn_elevar);
        p_inferior.add(btn_igual);
        
    }

    
    public void actionPerformed(ActionEvent e) {
    	
       String cadena = txt.getText();
       
       if (xd==1) {txt.setText("");}

       
       if(cadena.length() < 20) {
    	   
    	  if(e.getSource() == arr_btn[0]){
               txt.setText(txt.getText()+"0"); xd++;
          } 
          if(e.getSource() == arr_btn[1]){
               txt.setText(txt.getText()+"1"); xd++;
          }
          if(e.getSource() == arr_btn[2]){
               txt.setText(txt.getText()+"2"); xd++;
          }
          if(e.getSource() == arr_btn[3]){
               txt.setText(txt.getText()+"3"); xd++;
          }
          if(e.getSource() == arr_btn[4]){
               txt.setText(txt.getText()+"4"); xd++;
          }
          if(e.getSource() == arr_btn[5]){
               txt.setText(txt.getText()+"5"); xd++;
          }
          if(e.getSource() == arr_btn[6]){
               txt.setText(txt.getText()+"6"); xd++;
          }
          if(e.getSource() == arr_btn[7]){
               txt.setText(txt.getText()+"7"); xd++;
          }
          if(e.getSource() == arr_btn[8]){
               txt.setText(txt.getText()+"8"); xd++;
          }
          if(e.getSource() == arr_btn[9]){
               txt.setText(txt.getText()+"9"); xd++;
          }
          if(e.getSource() == btn_suma){
                txt.setText(txt.getText()+ "+");
          }
          if(e.getSource() == btn_resta){
              txt.setText(txt.getText()+ "-");
          }
          if(e.getSource() == btn_div){
              txt.setText(txt.getText()+ "/");
          }
          if(e.getSource() == btn_mult){
              txt.setText(txt.getText()+ "*");
          }  
          if(e.getSource() == btn_elevar){
              txt.setText(txt.getText()+ "^");
          }
          if(e.getSource() == btn_igual){

              for(int i = 0; i < cadena.length(); i++){

                  char caracter = cadena.charAt(i);

                  switch(caracter){
                       case '+':
                            String part1 = cadena.substring(0,i);
                            String part2 = cadena.substring(i+1, cadena.length());
                            int resultado = Integer.parseInt(part1) + Integer.parseInt(part2);
                            txt.setText(Integer.toString(resultado));
                            break;

                       case '-':

                            String par1 = cadena.substring(0,i);
                            String par2 = cadena.substring(i+1, cadena.length());
                            int resultad = Integer.parseInt(par1) - Integer.parseInt(par2);
                            txt.setText(Integer.toString(resultad));
                            break;

                       case '*':

                            String pa1 = cadena.substring(0,i);
                            String pa2 = cadena.substring(i+1, cadena.length());
                            int resul = Integer.parseInt(pa1) * Integer.parseInt(pa2);
                            txt.setText(Integer.toString(resul));
                            break;

                       case '/':

                            String p1 = cadena.substring(0,i);
                            String p2 = cadena.substring(i+1, cadena.length());

                           try{
                            int res = Integer.parseInt(p1) / Integer.parseInt(p2);
                             txt.setText(Integer.toString(res));
                            }
                            catch(ArithmeticException error){
                                 txt.setText("Math Error" + error.getMessage());
                            }
                            break;

                       case '^':

                            String pt1 = cadena.substring(0,i);
                            String pt2 = cadena.substring(i+1, cadena.length());
                            double a = Double.parseDouble(pt1);
                            double b = Double.parseDouble(pt2);
                            double resl = (Math.pow(a, b));                        
                            txt.setText(Double.toString(resl));
                            break;
                       default: break;
                  }
              }
              xd=1;
          }
          
       } else {
    	   
    	   System.out.println("Capacidad maxima de valores permitidos 20");
       }
       
    }

}