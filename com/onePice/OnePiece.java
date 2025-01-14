package com.onePice;

import java.util.Scanner;

public class OnePiece {
    char mapa [][] =new char[10][10];
    char num = 48;
    int x,y, contador =0;
    int myx,myy;
    Scanner sc =new Scanner(System.in);

    private void rellenaMapa(){
        for (int i = 0; i < mapa.length ; i++) {
            for (int j = 0; j < mapa.length; j++) {
                if(i == 0 && j != 0) mapa[i][j]=num;
                else if (i != 0 && j == 0) mapa[i][j]=num;
                else if (i != 0 && j != 0) mapa[i][j]='?';

                if(num ==57) num  =49;
                else num++;
            }

        }
    }

    private void dibujaMapa(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(mapa[i][j] + " ");

            }
            System.out.println();

        }
    }

    public void prueba(){
        rellenaMapa();
        dibujaMapa();
    }

    private boolean desenterrar(int x, int y){
        if (x > 0 && x<10 &&y>0 && y<10){
            contador++;
            if (this.x == x && this.y ==y){
                mapa[x][y] ='x';
                dibujaMapa();
                return true;
            }else{
                if (this.x != x){
                    if (this.x < x) mapa[x][y]='\u2191';//flecha hacia arriba
                    else mapa[x][y]='\u2193'; //flecha hacia abajo
                }else{
                    if (this.y < y)mapa[x][y]='<';
                    else mapa[x][y]='>';
                }
            }
            dibujaMapa();
            return false;

        }else{
            System.out.println("sos gilipollas o que ");
            return false;
        }

    }

    public void juagar(){
        x=(int) (Math.random() *9+1);
        y=(int) (Math.random() *9+1);
        rellenaMapa();
        dibujaMapa();
        do {
            System.out.println("elige la cordenada x ");
            myx = sc.nextInt();

            System.out.println("elige la cordenada y ");
            myy = sc.nextInt();


        }while(!desenterrar(myx,myy));
        System.out.println("has gabado numero de intentos: " + contador);


    }

}
